package service;
import exception.AuthenticationException;
import util.FileHandler;

public class AuthService {
    public static void login(String username, String password) {
        String line = FileHandler.retrieveLine(username, 2, password);

        if (line.equals(null)) {
            throw new AuthenticationException(username);
        }

        String[] credentials = line.split("\\|");
        // 0 - id, 1- createdAt, 2 - username, 3 - password, 4 - full name, 5 - role, 6 - status

        if (!username.equals(credentials[2]) && password.equals(credentials[3])) {
            throw new AuthenticationException(username);
        }

        if (credentials[0].split("-")[0].equals("A")) {
            
        }

    }

    public static void logout() {

    }
}