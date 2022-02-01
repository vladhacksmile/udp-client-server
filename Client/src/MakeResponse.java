import static java.lang.Integer.parseInt;

public class MakeResponse implements Runnable {
    private String line;
    private Collection collection = new Collection();

    public MakeResponse(String line) {
        this.line = line;
    }

    @Override
    public void run() {
        Object object = execute(line);
        if (object != null) {
            UDPSocketClient.send(object);
        }
    }

    public Object execute(String cmd) {
        String[] trimmedCommand = cmd.trim().split(" ", 2);
        Object command = null;
        try {
            switch (trimmedCommand[0]) {
                case "": break;
                case "help":
                case "info":
                case "show":
                case "clear":
                case "head":
                case "sum_of_annual_turnover":
                case "print_field_ascending_annual_turnover":
                    command = new Command(Auth.getUser(), trimmedCommand, cmd);
                    break;
                case "remove_by_id":
                    if (parseInt(trimmedCommand[1]) > 0) {
                        command = new Command(Auth.getUser(), trimmedCommand, cmd);
                    } else {
                        GUIManager.println(LocaleManager.getBundle().getString("message_id_incorrect_error"));
                    }
                    break;
                case "auth":
                    Auth.username = trimmedCommand[1];
                    // Auth.password = ConsoleEvent.getPassword();
                    Auth.authorized();
                    command = new Command(new User(Auth.username, Utils.getHash(Auth.password, "SHA-384"), LocaleManager.getLanguageId()), Utils.formRequest("auth"), null);
                    break;
                case "reg":
                    Auth.username = trimmedCommand[1];
                    // Auth.password = ConsoleEvent.getPassword()
                    Auth.authorized();
                    command = new Command(new User(Auth.username, Utils.getHash(Auth.password, "SHA-384"), LocaleManager.getLanguageId()), Utils.formRequest("reg"), null);
                    break;
                case "logout":
                    GUIManager.println(LocaleManager.getBundle().getString("message_logout"));
                    Main.mainForm.getLobbyForm().logout();
                    break;
                case "remove_any_by_type":
                    if(Utils.StrToType(trimmedCommand[1]) != null){
                        command = new Command(Auth.getUser(), trimmedCommand, cmd);
                    } else {
                        GUIManager.println(LocaleManager.getBundle().getString("message_incorrect_type_error"));
                    }
                    break;
                case "add":
                    command = new Command(Auth.getUser(), trimmedCommand, collection.add());
                    break;
                case "exit":
                    GUIManager.println(LocaleManager.getBundle().getString("message_exit"));
                    System.exit(0);
                    break;
                case "update":
                    try {
                        if (parseInt(trimmedCommand[1]) > 0) {
                            Object valueObject = null;
                            String field = ConsoleEvent.update();
                            switch (field) {
                                case "name":
                                    valueObject = ConsoleEvent.getName();
                                    break;
                                case "coordinates":
                                    valueObject = ConsoleEvent.getCoordinates();
                                    break;
                                case "annualturnover":
                                    valueObject = ConsoleEvent.getAnnualTurnover();
                                    break;
                                case "type":
                                    valueObject = ConsoleEvent.getType();
                                    break;
                                case "address":
                                    valueObject = ConsoleEvent.getAddress();
                                    break;
                                case "exit":
                                    GUIManager.println(LocaleManager.getBundle().getString("message_update_canceled"));
                                    break;
                                default:
                                    GUIManager.println(LocaleManager.getBundle().getString("message_update_field_error"));
                                    break;
                            }
                            command = new Command(Auth.getUser(), trimmedCommand, new Update(parseInt(trimmedCommand[1]), field, valueObject));
                        } else {
                            GUIManager.println(LocaleManager.getBundle().getString("message_id_incorrect_error"));
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        GUIManager.println(LocaleManager.getBundle().getString("message_argument_error"));
                    } catch (NumberFormatException e) {
                        GUIManager.println(LocaleManager.getBundle().getString("message_argument_id_error"));
                    }
                    break;
                case "execute_script":
                    UDPSocketClient.execute_script(trimmedCommand[1]);
                    break;
                case "remove_greater":
                    command = new Command(Auth.getUser(), trimmedCommand, new RemoveByElement(ConsoleEvent.getAnnualTurnover(), true));
                    break;
                case "remove_lower":
                    command = new Command(Auth.getUser(), trimmedCommand, new RemoveByElement(ConsoleEvent.getAnnualTurnover(), false));
                    break;
                default:
                    GUIManager.println(LocaleManager.getBundle().getString("message_unknown_command_error"));
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            GUIManager.println(LocaleManager.getBundle().getString("message_argument_error"));
        } catch (NumberFormatException e) {
            GUIManager.println(LocaleManager.getBundle().getString("message_argument_id_error"));
        }
        return command;
    }
}
