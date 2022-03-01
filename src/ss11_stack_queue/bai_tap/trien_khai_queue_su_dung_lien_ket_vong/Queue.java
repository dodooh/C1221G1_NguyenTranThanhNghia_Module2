package ss11_stack_queue.bai_tap.trien_khai_queue_su_dung_lien_ket_vong;

import java.util.NoSuchElementException;

public class Queue {

    private Node front;
    private Node rear;

    Queue() {
        front = null;
        rear = null;
    }

    Queue(int... arr) {
        for (int ele : arr) {
            this.enQueue(ele);
        }
    }

    void enQueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            newNode.next = newNode;
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            rear.next = newNode;
            rear = newNode;
        }
    }

    int deQueue() {
        if (front == null) {
            throw new NoSuchElementException("queue is empty");
        }
        if (front == rear) {
            int data = front.getData();
            front = null;
            rear = null;
            return data;
        } else {
            int data = front.getData();
            front = front.next;
            rear.next = front;
            return data;
        }
    }

    void displayQueue() {
        if (front == null) {
            return;
        }
        int size = 1;
        Node currentNode = front;
        while(currentNode.next != front) {
            System.out.printf("%-3d->", currentNode.getData());
            size++;
            currentNode = currentNode.next;
        }
        System.out.printf("%-3d->", currentNode.getData());
        System.out.print("--\n↑");
        for(int i = 0; i < size; i++) {
            System.out.print("     ");
        }
        System.out.print("|\n--");
        for(int i = 0; i < size; i++) {
            System.out.print("-----");
        }
        System.out.println();
    }
}
