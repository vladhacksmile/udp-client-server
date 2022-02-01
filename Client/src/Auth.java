import java.util.Scanner;

public class Auth {

    private static User user = new User("", "", 0);
    private static boolean auth = true;
    public static String username = "";
    public static String password = "";
    private static String[] authRequest = {"auth"};
    private static String[] regRequest = {"reg"};
    private static Scanner scanner = new Scanner(System.in);

    public static void authorized() {
        user = new User(username, Utils.getHash(password, "SHA-384"), LocaleManager.getLanguageId());
        UDPSocketClient.authorized = true;
    }

    public static void authorizedSucсessful() {
       Main.mainForm.authorized();
       auth = false;
       Main.mainForm.getLobbyForm().getHelloField().setText(String.format(LocaleManager.getBundle().getString("hello_user"), username));
    }

    public static void logout() {
        auth = true;
        UDPSocketClient.authorized = false;
        username = "";
        password = "";
        authorized();
    }

    public static User getUser() {
        user.setLanguageId(LocaleManager.getLanguageId());
        return user;
    }

    public static void setUser(User user) {
        Auth.user.setLanguageId(LocaleManager.getLanguageId());
        Auth.user = user;
    }

    public static boolean isAuth() {
        return auth;
    }
}
