
public class RegisterNewID {
    private String username;
    private String password;
    private UsernamesAndPasswords ID;

    RegisterNewID(String username,String password) {
        this.username = username;
        this.password = password;
        ID.getLoginInfo().put(username, password);
    }

}
