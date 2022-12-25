package program.backend.repository;

import program.backend.database.AccountDatabase;
import program.backend.model.Account;
import program.backend.request.ChangeUserNameRequest;
import program.backend.utils.FileUtils;

import java.util.ArrayList;

public class AccountRepository {
    private final AccountDatabase accountDatabase = new AccountDatabase();
    public Account changeUserName(ChangeUserNameRequest request) {
        Account account = new Account();
        account.setUserName(account.getUserName());

        FileUtils.setDataToFile("account.json",AccountDatabase.accounts);
        return account;
    }


    public ArrayList<Account> findAll() {
        return AccountDatabase.accounts;
    }
}
