package backend.repository;

import backend.database.UserDB;
import backend.exception.NotFoundException;
import backend.model.User;
import backend.request.ChangePassword;
import backend.request.ChangeUsername;
import backend.utils.UserUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class UserRepo {
    ArrayList<User> users = UserDB.users;
    Scanner sc = new Scanner(System.in);
    User user = new User();

    public ArrayList<User> findAll() {
        return UserDB.users;
    }

    public User findByEmail(String email) {
        for (User a : users
        ) {
            if (a.getEmail().equalsIgnoreCase(email)) {
                return a;
            }
        }
        throw new NotFoundException("Không tìm thấy email : " + email);
    }

    public void save(User user) {
        UserDB.users.add(user);
        UserUtils.setDataToFile("username.json", UserDB.users);
    }

    public User forgotPassWord(String email, ChangePassword rq) {
        User user = findByEmail(email);
        user.setPassWord(rq.getPassWord());
        UserUtils.setDataToFile("username.json", UserDB.users);
        return user;
    }

    public User changeUsername(String email, ChangeUsername request) {
        User user = findByEmail(email);
        user.setUserName(request.getUserName());
        UserUtils.setDataToFile("username.json", UserDB.users);
        return user;
    }

//    public void changePassword() {
//        System.out.println("Nhập Password mới: ");
//        String newPassword = scanner.nextLine();
//        account.setPassword(newPassword);
//        FileUtils.setDataToFile("accounts.json", AccountDB.accounts);
//    }
}

