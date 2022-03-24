package bai_tap.quan_ly_ngan_hang_8.models;


import static bai_tap.quan_ly_ngan_hang_8.utils.ValidatorInputLibrary.simpleDateFormat;

import java.util.Date;

public abstract class Account {

    private int accountID;
    private String accountCode;
    private String accountName;
    private Date createdDate;

    public Account(int accountID, String accountCode, String accountName, Date createdDate) {
        this.accountID = accountID;
        this.accountCode = accountCode;
        this.accountName = accountName;
        this.createdDate = createdDate;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return
            "accountID=" + accountID +
                ", accountCode='" + accountCode + '\'' +
                ", accountName='" + accountName + '\'' +
                ", createdDate=" + simpleDateFormat.format(createdDate);
    }

    public String toTableFormat() {
        return String.format("| %-5d | %-12s | %-20s | %-12s |",
            accountID, accountCode, accountName, simpleDateFormat.format(createdDate));

    }

    public String toCSVFormat() {
        return accountID +
            "," + accountCode +
            "," + accountName +
            "," + simpleDateFormat.format(createdDate);
    }
}
