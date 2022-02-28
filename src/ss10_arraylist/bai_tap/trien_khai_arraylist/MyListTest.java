package ss10_arraylist.bai_tap.trien_khai_arraylist;

public class MyListTest {

    public static void main(String[] args) {
        MyList<Account> accountMyList = new MyList<>(4);
        Account tempAccount = new Account(3, "Nguyen Van F", 200000);
        accountMyList.add(new Account(0, "Nguyen Van A", 200000));
        accountMyList.add(new Account(1, "Nguyen Van B", 600000));
        accountMyList.add(tempAccount);
        accountMyList.add(new Account(4, "Nguyen Van C", 500000));
        accountMyList.add(new Account(5, "Nguyen Van D", 700000));
        accountMyList.add(2, new Account(2, "Nguyen Van E", 800000));

        System.out.println(accountMyList.size());
        System.out.println(accountMyList.get(0));
        System.out.println(accountMyList.get(1));
        System.out.println(accountMyList.indexOf(tempAccount));
        System.out.println(accountMyList.contains(tempAccount));
        System.out.println("In ra từng phần tử trong danh sách: ");
        for (int i = 0; i < accountMyList.size(); i++) {
            System.out.println(accountMyList.get(i));
        }
//        System.out.println("Dùng phương thức clear()");
//        System.out.println("In ra từng phần tử trong mảng: ");
//        accountMyList.clear();
//        for (int i = 0; i < accountMyList.size(); i++) {
//            System.out.println(accountMyList.get(i));
//        }
        System.out.println("Dùng phương thức clone()");
        MyList<Account> s = accountMyList.clone();
        System.out.println("In ra từng phần tử trong danh sách mới: ");
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }

//        System.out.println(s.remove(10));
        System.out.println("Xóa phần tử ở vị trí index = 2");
        System.out.println(accountMyList.remove(2));
        System.out.println("In ra từng phần tử trong danh sách sau khi xóa: ");
        for (int i = 0; i < accountMyList.size(); i++) {
            System.out.println(accountMyList.get(i));
        }
    }
}
