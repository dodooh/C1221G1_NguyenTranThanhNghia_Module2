package ss10_arraylist.thuc_hanh.trien_khai_lop_linklist_don_gian;

public class TestMyLinkedList {

    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);

        ll.add(4, 9);
        ll.add(4, 20);
        ll.printList();
    }
}
