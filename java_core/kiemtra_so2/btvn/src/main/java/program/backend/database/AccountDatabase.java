package program.backend.database;

import program.backend.model.Account;
import program.backend.utils.FileUtils;

import java.util.ArrayList;

public class AccountDatabase {


    public static ArrayList<Account> accounts = FileUtils.getDataFromJsonFile("account.json");
}
