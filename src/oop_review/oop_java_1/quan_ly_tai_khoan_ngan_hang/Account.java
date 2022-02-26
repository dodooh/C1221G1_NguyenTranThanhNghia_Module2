package oop_review.oop_java_1.quan_ly_tai_khoan_ngan_hang;

import java.util.Scanner;

public class Account {

    private long accountNumber;
    private String accountName;
    private double balance;
    private final double LAISUAT = .035d;

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

    // Phương thức nạp tiền
    public void deposit() {
        double amount = getAmount();
        this.setBalance(this.getBalance() + amount);
    }

    // Phương thức rút tiền
    public void withdraw() {
        double amount = getAmount();
        this.setBalance(this.getBalance() - amount);
    }

    // Phương thức chuyển tiền
    public void transferTo(Account receiveAccount) {
        double amount = getAmount();
        this.setBalance(this.getBalance() - amount);
        receiveAccount.setBalance(receiveAccount.getBalance() + amount);
    }

    // Phương thức cập nhật đáo hạn
    public void updateBalance() {
        this.setBalance(this.getBalance() * (1 + LAISUAT));
    }

    @Override
    public String toString() {
        return "Account{" +
            "accountNumber=" + accountNumber +
            ", accountName='" + accountName + '\'' +
            ", balance=$" + String.format("%,.0f", balance) +
            '}';
    }

    // Trả về số tiền muốn thực hiện giao dịch
    // Yêu cầu nhập lại khi <= 0 hoặc > balance
    private double getAmount() {
        double amount;
        do {
            System.out.println("Nhập số tiền muốn thực hiện giao dịch: ");
            amount = new Scanner(System.in).nextDouble();
            if (amount <= 0) {
                System.out.println("Không hợp lệ. Nhập lại!");
            } else if (amount > balance) {
                System.out.println("Số tiền trong tài khoản không đủ để thực hiện.");
            } else {
                break;
            }
        } while (true);
        return amount;
    }
}
