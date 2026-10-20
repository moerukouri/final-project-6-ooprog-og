package repository;


import model.User;
import util.FileHandler;
import util.FilePath;

public class UserRepository {
    private static final String PATH = FilePath.USERS_PATH.getFilePath();

    public static void save(User user){
        FileHandler.write(user.toTextRow(), PATH, true);
    }
    
    public static User findByUsername(String username){
        String row = FileHandler.retrieveLine(username, 2, PATH);
        return row == null ? null : User.fromTextRow(row);
    }

    public static boolean exists(String id){
        return FileHandler.findID(id, PATH);
    }
}
