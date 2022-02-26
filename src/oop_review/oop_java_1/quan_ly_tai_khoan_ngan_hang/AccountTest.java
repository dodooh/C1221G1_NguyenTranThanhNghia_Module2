package oop_review.oop_java_1.quan_ly_tai_khoan_ngan_hang;

public class AccountTest {

    public static void main(String[] args) {
        Account account1 = new Account(125012,"Nguyen Van A", 20000);
        Account account2 = new Account(144999,"Tran Van B", 50000);
        System.out.println(account1);
        System.out.println(account2);
        System.out.println("---account1 thực hiện nạp tiền vào tài khoản---");
        account1.deposit();
        System.out.println(account1);
        System.out.println("---account2 thực hiện rút tiền---");
        account2.withdraw();
        System.out.println(account2);
        System.out.println("---account1 thực hiện chuyển tiền cho account2---");
        account1.transferTo(account2);
        System.out.println(account1);
        System.out.println(account2);
        System.out.println("---account2 thực hiện đáo hạn---");
        account2.updateBalance();
        System.out.println(account2);

    }
}
