package oop_review.oop_java_1.quan_ly_tai_khoan_ngan_hang;

import java.util.Scanner;

public class Account {

    private long accountNumber;
    private String accountName;
    private double balance;

    public Account(long accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public Account(long accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = 50;
    }

    public Account() {
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Phương thức nạp tiền
    public void deposit() {
        double MAXIMUM_DEPOSIT = 50000000;
        double amount;
        do {
            System.out.println("Nhập số tiền muốn thực hiện giao dịch: ");
            amount = new Scanner(System.in).nextDouble();
        } while (isNotValidAmount(amount, MAXIMUM_DEPOSIT));
        this.setBalance(this.getBalance() + amount);
    }

    // Phương thức rút tiền
    public void withdraw() {
        double amount;
        double PHI_RUT_TIEN = 3000;
        do {
            System.out.println("Nhập số tiền muốn thực hiện giao dịch: ");
            amount = new Scanner(System.in).nextDouble();
        } while (isNotValidAmount(amount, balance + PHI_RUT_TIEN));
        this.setBalance(this.getBalance() - (amount + PHI_RUT_TIEN));
    }

    // Phương thức chuyển tiền
    public void transferTo(Account receiveAccount) {
        double amount;
        do {
            System.out.println("Nhập số tiền muốn thực hiện giao dịch: ");
            amount = new Scanner(System.in).nextDouble();
        } while (isNotValidAmount(amount, balance));
        this.setBalance(this.getBalance() - amount);
        receiveAccount.setBalance(receiveAccount.getBalance() + amount);
    }

    // Phương thức cập nhật đáo hạn
    public void updateBalance() {
        double LAI_SUAT = .035d;
        this.setBalance(this.getBalance() * (1 + LAI_SUAT));
    }

    @Override
    public String toString() {
        return "Account{" +
            "accountNumber=" + accountNumber +
            ", accountName='" + accountName + '\'' +
            ", balance=$" + String.format("%,.0f", balance) +
            '}';
    }


    private boolean isNotValidAmount(double amount, double comparedAmount) {
        boolean flag = true;
        if (amount <= 0) {
            System.out.println("Không hợp lệ. Nhập lại!");
            flag = false;
        } else if (amount > comparedAmount) {
            System.out.println("Số tiền trong tài khoản không đủ để thực hiện.");
            flag = false;
        }
        return !flag;
    }
}
