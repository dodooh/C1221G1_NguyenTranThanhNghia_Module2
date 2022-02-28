package ss11_stack_queue.thuc_hanh.trien_khai_queue_dua_tren_linkedlist;

class Node<T> {
    public T key;
    public Node<T> next;

    public Node(T key) {
        this.key = key;
        this.next = null;
    }
}
