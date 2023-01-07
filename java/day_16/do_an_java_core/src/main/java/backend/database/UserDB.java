package backend.database;

import backend.model.User;
import backend.utils.UserUtils;
import frontend.UserUI;

import java.util.ArrayList;

public class UserDB {
    public static ArrayList<User> users = UserUtils.getDataFromJsonFile("username.json");



    public static void main(String[] args) {

    }
}
