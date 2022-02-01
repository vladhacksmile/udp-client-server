import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class AnswerHandler {

    private static Collection collection;
    private String path;
    private static final Logger userLogger = LogManager.getLogger(AnswerHandler.class);

    public AnswerHandler(String path) {
        this.path = path;
        collection = new Collection(path);
    }

    public String getPath() {
        return path;
    }

    public Answer getAnswer(Client client) {
        try {
            byte[] data = client.getIncomingData();
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream is = new ObjectInputStream(in);
            Command command = (Command) is.readObject();
            InetAddress IPAddress = ((InetSocketAddress) client.getClientAddress()).getAddress();
            int port = ((InetSocketAddress) client.getClientAddress()).getPort();
            Object object = null;
            if (command.getOrganization() != null) {
                object = command.getOrganization();
            } else if (command.getUpdate() != null) {
                object = command.getUpdate();
            } else if (command.getRemoveByElement() != null) {
                object = command.getRemoveByElement();
            }
            userLogger.info(IPAddress + ":" + port + " received command " + command.getArgs()[0]);
            if(command.getName().equals("auth") || command.getName().equals("reg")) {
                return auth(command.getArgs(), command.getUser());
            }
            if (command.getArgs()[0].equals("connect")) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("connected");
                userLogger.info("New user connected " + IPAddress + ":" + port);
                return new Answer(arrayList, false);
            }
            if(UDPSocketServer.getDatabaseManager().userExists(command.getUser())) {
                if(command.getArgs()[0].equals("getCollection"))  {
                    return new Answer(getCollection().getCollection(), true); // TODO
                } else if (command.getArgs()[0].equals("updateElement")){
                    try {
                        return new Answer(getCollection().updateElement(Integer.parseInt(command.getArgs()[1]), object, command.getUser()), true);
                    } catch (Exception e) {
                        userLogger.fatal("ПРОВЕРИТЬ ОБНОВЛЕНИЕ ЭЛЕМЕНТА!"); // TODO
                    }
                }
                return new Answer(execute(command.getArgs(), object, command.getUser()), true);
            }
            ArrayList<String> userNotAuthorized = new ArrayList<>();
            userNotAuthorized.add(LocaleManager.getBundleById(command.getUser().getLanguageId()).getString("message_user_not_authorized_error"));
            return new Answer(userNotAuthorized, false);
        } catch (IOException | ClassNotFoundException e) {
            userLogger.error(e.getMessage());
        }
        return null;
    }

    public ArrayList<String> execute(String[] trimmedCommand, Object object, User user) {
        ArrayList<String> answer = new ArrayList<>();
        try {
            switch (trimmedCommand[0]) {
                case "": break;
                case "help":
                    answer.add(LocaleManager.getBundleById(user.getLanguageId()).getString("message_help"));
                    break;
                case "info":
                    answer.add(collection.info(user));
                    break;
                case "show":
                    answer.addAll(collection.show(user));
                    break;
                case "add":
                    if(object != null) {
                        Organization organization = (Organization) object;
                        collection.addToCollectionFromClient(organization, user);
                        answer.add(LocaleManager.getBundleById(user.getLanguageId()).getString("message_added_successful"));
                    }
                    break;
                case "update":
                    try {
                        Update update = (Update) object;
                        answer.addAll(collection.updateFromClient(update.getId(), update.getField(), update.getValue(), user));
                    } catch (NumberFormatException e) {
                        answer.add(LocaleManager.getBundleById(user.getLanguageId()).getString("message_argument_id_error"));
                    } catch(NullPointerException e) {
                        answer.add(LocaleManager.getBundleById(user.getLanguageId()).getString("message_update_field_error"));
                    }
                    break;
                case "remove_by_id":
                    try {
                        answer.add(collection.remove_by_id(parseInt(trimmedCommand[1]), user));
                    } catch (NumberFormatException e) {
                        answer.add(LocaleManager.getBundleById(user.getLanguageId()).getString("message_argument_id_error"));
                    }
                    break;
                case "clear":
                    answer.add(collection.clearBy(user));
                    break;
                case "exit":
                    UDPSocketServer.stop();
                    answer.add(LocaleManager.getBundleById(user.getLanguageId()).getString("message_server_stopped"));
                    break;
                case "head":
                    answer.add(collection.head(user));
                    break;
                case "remove_greater":
                    RemoveByElement removeByElementGreater = (RemoveByElement) object;
                    answer.add(collection.remove_greater(removeByElementGreater.getValue(), user));
                    break;
                case "remove_lower":
                    RemoveByElement removeByElementLower = (RemoveByElement) object;
                    answer.add(collection.remove_lower(removeByElementLower.getValue(), user));
                    break;
                case "remove_any_by_type":
                    answer.add(collection.remove_any_by_type(trimmedCommand[1], user));
                    break;
                case "sum_of_annual_turnover":
                    answer.add(collection.sum_of_annual_turnover(user));
                    break;
                case "print_field_ascending_annual_turnover":
                    answer.addAll(collection.print_field_ascending_annual_turnover(user));
                    break;
                default:
                    answer.add(LocaleManager.getBundleById(user.getLanguageId()).getString("message_unknown_command_error"));
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            answer.add(LocaleManager.getBundleById(user.getLanguageId()).getString("message_argument_error"));
        }
        return answer;
    }

    public Answer auth(String[] trimmedCommand, User user) {
        ArrayList<String> answer = new ArrayList<>();
        boolean success = false;
        switch (trimmedCommand[0]) {
            case "auth":
                if(UDPSocketServer.getDatabaseManager().userExists(user)) {
                    answer.add(LocaleManager.getBundleById(user.getLanguageId()).getString("message_user_authorized"));
                    success = true;
                } else {
                    answer.add(LocaleManager.getBundleById(user.getLanguageId()).getString("message_user_not_found_error"));
                }
                break;
            case "reg":
                if(UDPSocketServer.getDatabaseManager().checkUsername(user)) {
                    answer.add(LocaleManager.getBundleById(user.getLanguageId()).getString("message_user_exists_error"));
                } else {
                    UDPSocketServer.getDatabaseManager().registerUser(user);
                    answer.add(String.format(LocaleManager.getBundleById(user.getLanguageId()).getString("message_user_registered"), user.getUsername()));
                    success = true;
                }
                break;
        }
        return new Answer(answer, success);
    }

    public static Collection getCollection() {
        return collection;
    }
}
