package ss11_stack_queue.thuc_hanh.trien_khai_queue_dua_tren_linkedlist;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue<String> queue = new MyLinkedListQueue<>();
        queue.enqueue("Hello1");
        queue.enqueue("Hello2");
        queue.enqueue("Hello3");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("Hello4");
        queue.enqueue("Hello5");
        queue.enqueue("Hello6");
        System.out.println("Dequeued item is " + queue.dequeue().key);
    }
}