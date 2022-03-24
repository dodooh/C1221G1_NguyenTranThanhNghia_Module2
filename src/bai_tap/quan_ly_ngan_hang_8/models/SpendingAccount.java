package bai_tap.quan_ly_ngan_hang_8.models;

import java.util.Date;

public class SpendingAccount extends Account {

    private String cardNumber;
    private double balance;

    public SpendingAccount(int accountID, String accountCode, String accountName, Date createdDate, String cardNumber, double balance) {
        super(accountID, accountCode, accountName, createdDate);
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "SpendingAccount{" +
            super.toString() +
            ", cardNumber='" + cardNumber + '\'' +
            ", balance=" + String.format("%,.0f", balance) +
            '}';
    }

    @Override
    public String toCSVFormat() {
        return super.toCSVFormat() +
            "," + cardNumber +
            "," + String.format("%.0f", balance);
    }

    @Override
    public String toTableFormat() {
        return super.toTableFormat() +
            String.format(" %16s | %,.0f", cardNumber, balance);
    }
}
