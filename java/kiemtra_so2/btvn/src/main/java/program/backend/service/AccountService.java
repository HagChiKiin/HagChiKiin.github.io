package program.backend.service;

import program.backend.model.Account;
import program.backend.repository.AccountRepository;
import program.backend.request.ChangeUserNameRequest;

import java.util.ArrayList;

public class AccountService {
    private final AccountRepository accountRepository = new AccountRepository();
    public Account changeUserName(ChangeUserNameRequest request) {
        return accountRepository.changeUserName(request);

    }

    public ArrayList<Account> findAll() {
       return accountRepository.findAll();
    }
}
