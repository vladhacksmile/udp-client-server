import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    private int languageId;

    public User(String username, String password, int languageId) {
        this.username = username;
        this.password = password;
        this.languageId = languageId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
