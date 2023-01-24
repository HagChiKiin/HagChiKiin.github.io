package backend.database;

import backend.model.Admin;
import backend.model.User;
import backend.utils.AdminUtils;

import java.util.ArrayList;

public class AdminDB {
    public static ArrayList<Admin> admins = AdminUtils.getDataFromJsonFile("admin.json");
}
