package bai_tap.quan_ly_ngan_hang_8.models;

import static bai_tap.quan_ly_ngan_hang_8.utils.ValidatorInputLibrary.simpleDateFormat;

import java.util.Date;

public class SavingAccount extends Account {

    private double savingMoney;
    private Date startSavingDate;
    private double interest;
    private int term;

    public SavingAccount(int accountID, String accountCode, String accountName, Date createdDate, double savingMoney, Date startSavingDate,
        double interest, int term) {
        super(accountID, accountCode, accountName, createdDate);
        this.savingMoney = savingMoney;
        this.startSavingDate = startSavingDate;
        this.interest = interest;
        this.term = term;
    }

    public double getSavingMoney() {
        return savingMoney;
    }

    public void setSavingMoney(double savingMoney) {
        this.savingMoney = savingMoney;
    }

    public Date getStartSavingDate() {
        return startSavingDate;
    }

    public void setStartSavingDate(Date startSavingDate) {
        this.startSavingDate = startSavingDate;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
            super.toString() +
            ", savingMoney=" + String.format("%,.0f", savingMoney) +
            ", startSavingDate=" + simpleDateFormat.format(startSavingDate) +
            ", interest=" + interest + "%" +
            ", term=" + term +
            '}';
    }

    @Override
    public String toCSVFormat() {
        return super.toCSVFormat() +
            "," + String.format("%.0f", savingMoney) +
            "," + simpleDateFormat.format(startSavingDate) +
            "," + interest +
            "," + term;
    }

    @Override
    public String toTableFormat() {
        return super.toTableFormat()
            + String.format("%,.0f | %-10s | %4.1f | %3d", savingMoney, simpleDateFormat.format(startSavingDate), interest, term);
    }
}
