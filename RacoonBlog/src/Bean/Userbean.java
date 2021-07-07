package Bean;

public class Userbean {
    private String username;
    private String password;
    private boolean isAdmin;

    public Userbean(){
        this.username = null;
        this.password = null;
        this.isAdmin = false;
    }
    public Userbean(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
