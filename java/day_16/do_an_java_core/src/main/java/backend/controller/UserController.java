package backend.controller;

import backend.model.User;
import backend.request.ChangePassword;
import backend.request.ChangeUsername;
import backend.request.CreateUser;
import backend.service.UserService;

import java.util.ArrayList;

public class UserController {
    private final UserService userService = new UserService();
    public ArrayList<User> findAll() {
        return userService.findAll();
    }

    public User register(CreateUser rq) {
        return userService.register(rq);
    }

    public User forgotPassWord(String email, ChangePassword rq) {
        return userService.forgotPassWord(email,rq);
    }

    public User changeUsername(String email, ChangeUsername request) {
        return  userService.changeUsername(email,request);

    }
}
