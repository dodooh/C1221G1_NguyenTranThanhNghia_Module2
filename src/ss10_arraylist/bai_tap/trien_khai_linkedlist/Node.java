package ss10_arraylist.bai_tap.trien_khai_linkedlist;

public class Node {
    Node next;
    private Object data;

    Node(Object data) {
        this.data = data;
        this.next = null;
    }

    Object getData() {
        return this.data;
    }
}
