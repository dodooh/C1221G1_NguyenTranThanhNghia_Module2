package ss10_arraylist.bai_tap.trien_khai_linkedlist;

import ss5_access_modifier_static.thuc_hanh.static_method.Student;

public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<Account> accounts = new MyLinkedList<>();

        Account account1 = new Account(1, "Nguyen Van A", 200000);
        Account account2 = new Account(2, "Nguyen Van B", 200000);
        Account account3 = new Account(3, "Nguyen Van C", 200000);
        Account account4 = new Account(4, "Nguyen Van D", 200000);
        Account account5 = new Account(5, "Nguyen Van E", 200000);
        Account accountTest = new Account(10, "Nguyen Van TEST", 200000);

        System.out.println("=======Test add()/addFirst()/addLast()=======");
        accounts.addFirst(account3);
        accounts.addFirst(account2);
        accounts.addFirst(account1);
        accounts.addLast(account4);
        accounts.addLast(account5);
        System.out.println(accounts.size());
        accounts.add(4, accountTest);
        accounts.printList();

        System.out.println("=======Test get()/getFirst()/getLast()=======");
        System.out.println(accounts.get(3));
        System.out.println(accounts.getFirst());
        System.out.println(accounts.getLast());

        System.out.println("=======Test indexOf()/contains()=======");
        System.out.println("indexOf new Account(): " + accounts.indexOf(new Account()));
        System.out.println("contains accountTest? " + accounts.contains(accountTest));

        System.out.println("=======Test remove(int index)/ remove(Object o)=======");
        System.out.println("remove(0): " + accounts.remove(0));
        System.out.println("remove(accountTest)" + accounts.remove(accountTest));
        System.out.println("LinkedList Account Remain:");
        accounts.printList();

        System.out.println("=======Test clone()=======");
        MyLinkedList<Account> accounts2 = accounts.clone();
        System.out.println("LinkedList accounts2:");
        accounts2.printList();


    }
}
