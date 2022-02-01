import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class UDPSocketClient {

    public static DatagramChannel channel;
    public static boolean runnable = true;
    public static boolean authorized = false;
    public static int PORT = 50001;
    public static InetAddress IPAddress;
    private static List<String> stackEvent = new ArrayList<>();
    private static Collection collection = new Collection();
    private static SocketAddress serverAddress = new InetSocketAddress("localhost",
            PORT);
    private static boolean init = false;
    public static boolean connected = false;
    public static boolean started = false;
    public static Object lastCommand = null;
    public static Thread responseHandlerThread = new Thread(new ResponseHandler());
    private static String[] authRequest = {"auth"};
    private static String[] regRequest = {"reg"};

    public boolean init() {
        if (init && runnable) {
            System.err.println(LocaleManager.getBundle().getString("message_client_already_run"));
        } else {
            connect();
            responseHandlerThread.start();
            runnable = true;
            init = true;
            authorized = true;
            start();
        }
        return runnable;
    }

    public static void start() {
        started = true;
    }

    public static void stop() {
        started = false;
    }

    public static void close() {
        started = false;
        System.out.println(LocaleManager.getBundle().getString("message_client_close"));
        System.exit(0);
    }

    public static boolean connect() {
        try {
            IPAddress = InetAddress.getByName("localhost");
            System.out.println(LocaleManager.getBundle().getString("message_try_to_connect_to_server") + IPAddress + ":" + PORT);
            channel = DatagramChannel.open();
            channel.configureBlocking(false);
            channel.connect(serverAddress);
            String[] connect = {"connect"};
            send(new Command(Auth.getUser(), connect, null));
            runnable = true;
            return true;
        }  catch(PortUnreachableException e) {
            System.err.println(LocaleManager.getBundle().getString("message_connect_to_server_failed_error"));
        } catch (SocketException e) {
            System.err.println(LocaleManager.getBundle().getString("message_socket_error"));
        } catch (UnknownHostException e) {
            System.err.println(LocaleManager.getBundle().getString("message_connect_to_host_error"));
        } catch (IOException e) {
            System.err.println(LocaleManager.getBundle().getString("message_connect_to_server_failed_error"));
        }
        runnable = false;
        return false;
    }

    public static void send(Object object) {
        try {
            if(!((Command) object).getArgs()[0].equals("connect")) {
                lastCommand = object;
            }
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(outputStream);
            os.writeObject(object);
            ByteBuffer buffer = ByteBuffer.wrap(outputStream.toByteArray());
            channel.send(buffer, serverAddress);
        } catch(IOException e) {
            GUIManager.println(LocaleManager.getBundle().getString("message_send_request_error"));
            runnable = false;
        }
    }

    public static Object execute(String cmd, BufferedReader bufferedReader) {
        String[] trimmedCommand = cmd.trim().split(" ", 2);
        Object command = null;
        try {
            switch (trimmedCommand[0]) {
                case "": break;
                case "help":
                case "info":
                case "show":
                case "clear":
                case "exit":
                case "head":
                case "sum_of_annual_turnover":
                case "print_field_ascending_annual_turnover":
                    command = new Command(Auth.getUser(), trimmedCommand, cmd);
                    break;
                case "remove_by_id":
                    if(parseInt(trimmedCommand[1]) > 0) {
                        command = new Command(Auth.getUser(), trimmedCommand, cmd);
                    } else {
                        GUIManager.println(LocaleManager.getBundle().getString("message_id_incorrect_error"));
                    }
                    break;
                case "remove_any_by_type":
                    if(Utils.StrToType(trimmedCommand[1]) != null) {
                        command = new Command(Auth.getUser(), trimmedCommand, cmd);
                    } else {
                        GUIManager.println(LocaleManager.getBundle().getString("message_incorrect_type_error"));
                    }
                    break;
                case "add":
                    command = new Command(Auth.getUser(), trimmedCommand, collection.add(bufferedReader));
                    break;
                case "update":
                    if (parseInt(trimmedCommand[1]) > 0) {
                        Object valueObject = null;
                        String field = ConsoleEvent.update(bufferedReader);
                        switch (field) {
                            case "name":
                                valueObject = ConsoleEvent.getName(bufferedReader);
                                break;
                            case "coordinates":
                                valueObject = ConsoleEvent.getCoordinates(bufferedReader);
                                break;
                            case "annualturnover":
                                valueObject = ConsoleEvent.getAnnualTurnover(bufferedReader);
                                break;
                            case "type":
                                valueObject = ConsoleEvent.getType(bufferedReader);
                                break;
                            case "address":
                                valueObject = ConsoleEvent.getAddress(bufferedReader);
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
                    break;
                case "remove_greater":
                    command = new Command(Auth.getUser(), trimmedCommand, new RemoveByElement(ConsoleEvent.getAnnualTurnover(bufferedReader), true));
                    break;
                case "remove_lower":
                    command = new Command(Auth.getUser(), trimmedCommand, new RemoveByElement(ConsoleEvent.getAnnualTurnover(bufferedReader), false));
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

    public static void execute_script(String path) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String cmd;
        stackEvent.add(path);
        try {
            File file = new File(path);
            if(file.exists() && !file.canWrite()) {
                throw new FileAccessException(LocaleManager.getBundle().getString("message_no_rights_file"));
            }
            inputStreamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(inputStreamReader);
            while ((cmd = bufferedReader.readLine()) != null) {
                String[] trimmedCommand = cmd.trim().split(" ", 2);
                try {
                    if (trimmedCommand[0].equals("execute_script")) {
                        for (String s : stackEvent) {
                            if (trimmedCommand[1].equals(s)) throw new RecursionException(LocaleManager.getBundle().getString("message_recursion_error"));
                        }
                    }
                    if (trimmedCommand[0].equals("add") || trimmedCommand[0].equals("update") || trimmedCommand[0].equals("remove_greater") || trimmedCommand[0].equals("remove_lower")) {
                        send(execute(cmd, bufferedReader));
                    } else {
                        send(new Command(Auth.getUser(), trimmedCommand, null));
                    }
                } catch (RecursionException e) {
                    GUIManager.println(e.getMessage());
                }
            }
        } catch(UnsupportedEncodingException e){
            GUIManager.println(LocaleManager.getBundle().getString("message_unsupported_charset_error"));
        } catch(FileNotFoundException e) {
            GUIManager.println(LocaleManager.getBundle().getString("message_file_not_found_error"));
        } catch(IOException e) {
            GUIManager.println(LocaleManager.getBundle().getString("message_read_file_error"));
        } catch (FileAccessException e) {
            GUIManager.println(e.getMessage());
        } finally {
            stackEvent.remove(stackEvent.size() - 1);
        }
    }
}