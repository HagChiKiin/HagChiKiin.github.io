package backend.service;

import backend.model.Admin;
import backend.repository.AdminRepo;
import backend.request.ChangePassword;

import java.util.ArrayList;

public class AdminService {
    AdminRepo adminRepo = new AdminRepo();

    public ArrayList<Admin> findAll() {
        return  adminRepo.findAll();
    }

    public Admin forgotPassWord(String email, ChangePassword rq) {
        return adminRepo.forgotPassWord(email,rq);
    }
}
