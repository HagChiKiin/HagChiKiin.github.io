package program.backend.repository;

import program.backend.database.AccountDatabase;
import program.backend.exception.NotFoundException;
import program.backend.model.Account;
import program.backend.request.ChangeRequest;
import program.backend.utils.FileUtils;

import java.util.ArrayList;

public class AccountRepository {
    private final AccountDatabase accountDatabase = new AccountDatabase();
    ArrayList<Account> accounts = AccountDatabase.accounts;

    public Account findByEmail(String email) {
        for (Account a : AccountDatabase.accounts
        ) {
            if (a.getEmail().equals(email)) {
                return a;
            }
        }
        throw new NotFoundException("Không tìm thấy email : " + email);
    }

    public ArrayList<Account> findAll() {
        return AccountDatabase.accounts;
    }

    public Account changeUserName(String email, ChangeRequest request) {
        Account account = findByEmail(email);
        account.setUserName(request.getUserName());

        FileUtils.setDataToFile("account.json", AccountDatabase.accounts);
        return account;
    }

    public Account changeEmail(String email, ChangeRequest request) {
        Account account = findByEmail(email);
        account.setEmail(request.getEmail());
        FileUtils.setDataToFile("account.json", AccountDatabase.accounts);
        return account;
    }

    public Account changePassWord(String email, ChangeRequest request) {
        Account account = findByEmail(email);
        account.setPassWord(request.getPassWord());
        FileUtils.setDataToFile("account.json", AccountDatabase.accounts);
        return account;
    }

    public void save(Account account) {
        AccountDatabase.accounts.add(account);
        FileUtils.setDataToFile("account.json", AccountDatabase.accounts);
    }

    public Account forgotPassWord(String email, ChangeRequest request) {
        Account account = findByEmail(email);
        account.setPassWord(request.getPassWord());
        FileUtils.setDataToFile("account.json", AccountDatabase.accounts);
        return account;
    }
}
