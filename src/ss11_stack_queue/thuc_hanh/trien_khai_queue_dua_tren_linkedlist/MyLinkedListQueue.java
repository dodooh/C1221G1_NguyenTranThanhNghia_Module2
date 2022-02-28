package ss11_stack_queue.thuc_hanh.trien_khai_queue_dua_tren_linkedlist;

public class MyLinkedListQueue<T> {

    private Node<T> front;
    private Node<T> rear;

    public MyLinkedListQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(T key) {
        Node<T> temp = new Node<T>(key);
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }

    public Node<T> dequeue() {
        if (this.front == null)
            return null;
        Node<T> temp = this.front;
        this.front = this.front.next;
        if (this.front == null)
            this.rear = null;
        return temp;
    }
}
