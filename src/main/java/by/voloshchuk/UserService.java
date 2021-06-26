package by.voloshchuk;

import by.voloshchuk.entity.User;
import org.mindrot.jbcrypt.BCrypt;

public class UserService {

    public static void addUser(User user) {
//        Password
        user.getPassword();
        String password = "abcd";
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hash);
        System.out.println(BCrypt.checkpw(password, hash));
    }

    public static void resetPassword(User user) {
//        Password
        user.getPassword();
        String password = "abcd";
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hash);
        System.out.println(BCrypt.checkpw(password, hash));
    }

}
