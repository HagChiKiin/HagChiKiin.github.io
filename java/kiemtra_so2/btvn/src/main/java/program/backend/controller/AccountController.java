package program.backend.controller;

import program.backend.model.Account;
import program.backend.request.ChangeUserNameRequest;
import program.backend.service.AccountService;

import java.util.ArrayList;

public class AccountController {
    private final AccountService accountService = new AccountService();
    public Account changeUserName(ChangeUserNameRequest request) {
        return accountService.changeUserName(request);
    }

    public ArrayList<Account> findAll() {
        return accountService.findAll();
    }
}