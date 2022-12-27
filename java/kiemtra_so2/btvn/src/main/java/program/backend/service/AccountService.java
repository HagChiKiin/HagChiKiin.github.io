package program.backend.service;

import program.backend.model.Account;
import program.backend.repository.AccountRepository;
import program.backend.request.ChangeRequest;

import java.util.ArrayList;

public class AccountService {
    private final AccountRepository accountRepository = new AccountRepository();
    public Account changeUserName(String email, ChangeRequest request) {
       return accountRepository.changeUserName(email,request);

    }

    public ArrayList<Account> findAll() {
       return accountRepository.findAll();
    }


    public Account changeEmail(String email, ChangeRequest request) {
        return accountRepository.changeEmail(email,request);
    }

    public Account changPassWord(String email, ChangeRequest request) {
        return accountRepository.changePassWord(email,request);
    }
    public Account register(ChangeRequest request) {
        Account account = new Account();
        account.setUserName(request.getUserName());
        account.setEmail(request.getEmail());
        account.setPassWord(request.getPassWord());
        accountRepository.save(account);
        return account;
    }

    public Account forgotPassWord(String email, ChangeRequest request) {
        return accountRepository.forgotPassWord(email,request);
    }

}
