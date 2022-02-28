package ss10_arraylist.bai_tap.trien_khai_arraylist;

public class Account {

    private long accountNumber;
    private String accountName;
    private double balance;

    public Account(long accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
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

    @Override
    public String toString() {
        return "Account{" +
            "accountNumber=" + accountNumber +
            ", accountName='" + accountName + '\'' +
            ", balance=$" + String.format("%,.0f", balance) +
            '}';
    }
}
