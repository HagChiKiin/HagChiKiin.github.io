package program.backend.controller;

import program.backend.model.Account;
import program.backend.request.ChangeRequest;
import program.backend.service.AccountService;

import java.util.ArrayList;

public class AccountController {
    private final AccountService accountService = new AccountService();
    public Account changeUserName(String email, ChangeRequest request) {
        return accountService.changeUserName(email,request);
    }

    public ArrayList<Account> findAll() {
        return accountService.findAll();
    }


    public Account changeEmail(String email, ChangeRequest request) {
        return accountService.changeEmail(email,request);
    }

    public Account changePassWord(String email, ChangeRequest request) {
        return accountService.changPassWord(email,request);
    }

    public Account register(ChangeRequest request) {
        return accountService.register(request);
    }
}