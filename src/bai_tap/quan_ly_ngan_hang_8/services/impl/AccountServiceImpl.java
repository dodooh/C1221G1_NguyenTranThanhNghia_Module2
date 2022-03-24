package bai_tap.quan_ly_ngan_hang_8.services.impl;

import bai_tap.quan_ly_ngan_hang_8.models.Account;
import bai_tap.quan_ly_ngan_hang_8.services.IService;
import bai_tap.quan_ly_ngan_hang_8.utils.NotFoundBankAccountException;
import bai_tap.quan_ly_ngan_hang_8.utils.ParseObjectException;
import bai_tap.quan_ly_ngan_hang_8.utils.ReadWriteCSVFile;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements IService<Account> {

    private static final String FILE_PATH = "src/bai_tap/quan_ly_ngan_hang_8/data/accounts.csv";
    private static List<Account> accountList = new ArrayList<>();

    static {
        try {
            accountList = ReadWriteCSVFile.readAccountListFromCSVFile(FILE_PATH);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ParseObjectException e) {
            System.out.println(e.getMessage());
        }
    }

    private final String TITLE_OF_CSV = "accountID,accountCode,accountNumber,createdDate";

    public static int findGoodID() {
        if (accountList.size() == 0) {
            return 1;
        } else {
            return accountList.get(accountList.size() - 1).getAccountID() + 1;
        }
    }

    public static List<Account> getAccountList() {
        return accountList;
    }


    @Override
    public void create(Account account) {
        accountList.add(account);
        // ghi file
        ReadWriteCSVFile.writeListToCSVFile(accountList, FILE_PATH, TITLE_OF_CSV);
        System.out.println("✔ Add Successfully");
    }

    @Override
    public void display() {
        System.out.println("=====DISPLAY ACCOUNT LIST=====");
        if (accountList.size() != 0) {
            int index = 0;
            System.out.printf("| %-5s | %-12s | %-20s | %-12s | %-16s | %-12s\n", "STT", "Account Code", "Account Name", "Created Date",
                "Card Number", "Balance");
            for (Account account : accountList) {
                System.out.println(account.toTableFormat());
            }
        } else {
            System.out.println("!!!Account List Is Empty!!!");
        }
    }

    public Account findAccountByExactID(String accountCode) throws NotFoundBankAccountException {
        if (accountList.size() != 0) {
            for (Account account : accountList) {
                if (accountCode.equals(account.getAccountCode())) {
                    return account;
                }
            }
            throw new NotFoundBankAccountException();
        } else {
            System.out.println("!!!Account List Is Empty!!!");
            return null;
        }
    }

    public void searchAndDisplayAccountsByKey(String key) {
        List<Account> accountListFromCSV = null;
        boolean isFound = false;
        try {

            accountListFromCSV = ReadWriteCSVFile.readAccountListFromCSVFile(FILE_PATH);
            for (Account account : accountListFromCSV) {
                if (account.getAccountCode().contains(key)
                    || account.getAccountName().toLowerCase().contains(key.toLowerCase())) {
                    System.out.println(account);
                    isFound = true;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ParseObjectException e) {
            System.out.println(e.getMessage());
        }
        if (!isFound) {
            System.out.println("No account founds with key " + key);
        }
    }

    @Override
    public void remove(Account account) {
        accountList.remove(account);
        ReadWriteCSVFile.writeListToCSVFile(accountList, FILE_PATH, TITLE_OF_CSV);
        System.out.println("✔ Remove Successfully");
    }
}
