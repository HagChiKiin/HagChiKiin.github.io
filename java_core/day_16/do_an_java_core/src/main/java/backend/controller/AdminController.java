package backend.controller;

import backend.model.Admin;
import backend.request.ChangePassword;
import backend.service.AdminService;

import java.util.ArrayList;

public class AdminController {
    AdminService adminService = new AdminService();

    public ArrayList<Admin> findAll() {
        return  adminService.findAll();
    }

    public Admin forgotPassWord(String email, ChangePassword rq) {
        return adminService.forgotPassWord(email,rq);
    }
}
