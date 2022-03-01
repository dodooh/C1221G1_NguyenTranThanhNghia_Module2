package ss11_stack_queue.bai_tap.trien_khai_queue_su_dung_lien_ket_vong;

public class Node {

    public Node next;
    private int data;

    Node() {
    }

    Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
