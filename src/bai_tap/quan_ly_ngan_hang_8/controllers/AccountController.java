package bai_tap.quan_ly_ngan_hang_8.controllers;

import static bai_tap.quan_ly_ngan_hang_8.controllers.MainController.INVALID_INDEX_WARNING;
import static bai_tap.quan_ly_ngan_hang_8.controllers.MainController.NUMBER_FORMAT_WARNING;
import static bai_tap.quan_ly_ngan_hang_8.controllers.MainController.YOUR_CHOICE;
import static bai_tap.quan_ly_ngan_hang_8.controllers.MainController.scanner;
import static bai_tap.quan_ly_ngan_hang_8.utils.ReadInputFromKeyBoard.*;
import static bai_tap.quan_ly_ngan_hang_8.utils.ReadInputFromKeyBoard.inputValidCreatedDateTime;

import bai_tap.quan_ly_ngan_hang_8.models.Account;
import bai_tap.quan_ly_ngan_hang_8.models.SavingAccount;
import bai_tap.quan_ly_ngan_hang_8.models.SpendingAccount;
import bai_tap.quan_ly_ngan_hang_8.services.impl.AccountServiceImpl;
import bai_tap.quan_ly_ngan_hang_8.utils.NotFoundBankAccountException;
import bai_tap.quan_ly_ngan_hang_8.utils.ValidatorInputLibrary;
import java.util.Date;
import java.util.List;

public class AccountController {

    AccountServiceImpl accountService = new AccountServiceImpl();
    private int accountID;
    private String accountCode;
    private String accountName;
    private Date createdDate;

    void create() {
        int menuChoice;
        boolean flag = true;
        do {
            try {
                System.out.println("[1] - Spending Account\n[2] - SavingAccount\n[0] - Back");
                System.out.print(YOUR_CHOICE);
                menuChoice = Integer.parseInt(scanner.nextLine());
                switch (menuChoice) {
                    case 1:
                        createNewSpendingAccount();
                        break;
                    case 2:
                        createNewSavingAccount();
                        break;
                    case 0:
                        System.out.println("Return...");
                        flag = false;
                        break;
                    default:
                        System.out.println(INVALID_INDEX_WARNING);
                }
            } catch (NumberFormatException e) {
                System.out.println(NUMBER_FORMAT_WARNING);
            }
        } while (flag);
    }

    public void display() {
        accountService.display();
    }

    public void remove() {
        display();
        String input;
        String confirm;
        Account foundAccount;
        do {
            System.out.println("Please enter account code to remove or \"exit\" to exit");
            input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            } else {
                try {
                    foundAccount = accountService.findAccountByExactID(input);
                    System.out.printf("FOUND: %s\n", foundAccount);
                    System.out.print("Do you want to remove (YES/NO)? ");
                    if ("YES".equalsIgnoreCase(scanner.nextLine())) {
                        accountService.remove(foundAccount);
                    }
                    break;
                } catch (NotFoundBankAccountException e) {
                    System.out.println(e.getMessage());
                }
            }
        } while (true);
    }

    public void search() {
        System.out.println("Enter Account-Name or Account-Code to Find");
        String input = scanner.nextLine();
        accountService.searchAndDisplayAccountsByKey(input);
    }

    private void createNewSpendingAccount() {
        inputCommonProperties();
        String cardNumber = inputValidData("Card Number (16 NUMBERS)", ValidatorInputLibrary.CARD_NUMBER);
        double balance = inputValidMoney("Account Balance");
        accountService.create(new SpendingAccount(accountID, accountCode, accountName, createdDate, cardNumber, balance));
    }

    private void createNewSavingAccount() {
        inputCommonProperties();
        double savingMoney = inputValidMoney("Saving Money");
        Date startSavingDate = inputValidStartSavingDateTime(createdDate);
        double interest = Double.parseDouble(inputValidData("Interest (%)", ValidatorInputLibrary.REAL_POSITIVE_NUMBER));
        int term = Integer.parseInt(inputValidData("Term (Month)", ValidatorInputLibrary.LARGER_THAN_0_NUMBER));
        accountService.create(new SavingAccount(accountID, accountCode, accountName, createdDate, savingMoney, startSavingDate, interest, term));
    }

    private void inputCommonProperties() {
        accountID = AccountServiceImpl.findGoodID();
        accountCode = inputValidData("Account code (12 NUMBERS)", ValidatorInputLibrary.ACCOUNT_CODE);
        accountName = inputValidData("Account Name", ValidatorInputLibrary.STANDARD_NAME);
        createdDate = inputValidCreatedDateTime();
    }
}
