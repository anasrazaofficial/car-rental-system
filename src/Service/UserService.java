package Service;


public class UserService {

    public Boolean isAuthenticate(String username, String passcode) {
        return username.equals("admin") && passcode.equals("admin");
    }
}
