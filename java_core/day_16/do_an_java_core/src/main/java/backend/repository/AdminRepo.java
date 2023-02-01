package backend.repository;

import backend.database.AdminDB;
import backend.exception.NotFoundException;
import backend.model.Admin;
import backend.model.User;
import backend.request.ChangePassword;
import backend.utils.AdminUtils;

import java.util.ArrayList;

import static backend.database.AdminDB.*;

public class AdminRepo {
    ArrayList<Admin> admins = AdminDB.admins;

    public ArrayList<Admin> findAll() {
       return AdminDB.admins;
    }
    public Admin findByEmail(String email) {
        for (Admin a : admins
        ) {
            if (a.getEmail().equalsIgnoreCase(email)) {
                return a;
            }
        }
        throw new NotFoundException("Không tìm thấy email : " + email);// Xử lý ngoại lệ unchecked exception
    }

    public Admin forgotPassWord(String email, ChangePassword rq) {
        Admin admin = findByEmail(email);
        admin.setPassWord(rq.getPassWord());
        AdminUtils.setDataToFile("admin.json",AdminDB.admins);
        return admin;
    }
}
