package backend.service;

import backend.model.User;
import backend.repository.UserRepo;
import backend.request.ChangePassword;
import backend.request.ChangeUsername;
import backend.request.CreateUser;

import java.util.ArrayList;

public class UserService {
    private final UserRepo userRepo = new UserRepo();

    public ArrayList<User> findAll() {
        return userRepo.findAll();
    }

    public User register(CreateUser rq) {
        User user = new User();
        user.setUserName(rq.getUserName());
        user.setEmail(rq.getEmail());
        user.setPassWord(rq.getPassWord());
        userRepo.save(user);
        return user;

    }

    public User forgotPassWord(String email, ChangePassword rq) {
        return userRepo.forgotPassWord(email, rq);
    }

    public User changeUsername(String email, ChangeUsername request) {
        return userRepo.changeUsername(email, request);
    }
}
