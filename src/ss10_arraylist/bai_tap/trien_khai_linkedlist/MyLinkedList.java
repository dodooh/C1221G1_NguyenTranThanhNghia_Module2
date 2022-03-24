package ss10_arraylist.bai_tap.trien_khai_linkedlist;

import ss10_arraylist.bai_tap.trien_khai_arraylist.MyList;

public class MyLinkedList<E> {

    private Node head;
    private int numNodes;

    MyLinkedList() {
        head = null;
        numNodes = 0;
    }

    public void setNumNodes(int numNodes) {
        this.numNodes = numNodes;
    }

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.next;
        }
    }

    int size() {
        return this.numNodes;
    }

    E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IllegalArgumentException("Invalid index " + index);
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return (E) currentNode.getData();
    }

    E getFirst() {
        return (E) head.getData();
    }

    E getLast() {
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return (E) currentNode.getData();
    }

    void addFirst(E element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    void addLast(E element) {
        if (head == null) {
            addFirst(element);
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            Node newNode = new Node(element);
            newNode.next = null;
            currentNode.next = newNode;
            numNodes++;
        }

    }

    void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IllegalArgumentException("Invalid Index " + index);
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == numNodes) {
            addLast(element);
        } else {
            Node currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            Node newNode = new Node(element);
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            numNodes++;
        }
    }

    void clear() {
        numNodes = 0;
        head = null;
    }

    int indexOf(E element) {
        int i = 0;
        Node currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.getData().equals(element)) {
                return i;
            }
            i++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    boolean contains(E element) {
        return this.indexOf(element) != -1;
    }

    private E removeFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Empty Linked List");
        }
        Node currentNode = head;
        head = head.next;
        numNodes--;
        return (E) currentNode.getData();
    }

    E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IllegalArgumentException("Invalid Index " + index);
        }
        if (index == 0) {
            return removeFirst();
        }
        Node currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }
        Node removedNode = currentNode.next;
        currentNode.next = currentNode.next.next;
        numNodes--;
        return (E) removedNode.getData();
    }

    E remove(Object o) {
        if (head == null) {
            throw new IndexOutOfBoundsException("Empty Linked List");
        }
        if (head.getData().equals(o)) {
            return removeFirst();
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.getData().equals(o)) {
                Node removedNode = currentNode.next;
                currentNode.next = currentNode.next.next;
                numNodes--;
                return (E) removedNode.getData(); // return (E) o;
            }
            currentNode = currentNode.next;
        }
        return null; // KHONG TIM THAY
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> newLinkedList = new MyLinkedList<>();
        // head == null
        if (head == null) {
            return newLinkedList;
        }
        // Tao head cho newLinkedList
        newLinkedList.head = new Node(head.getData());
        newLinkedList.setNumNodes(1);
        // Nối đuôi
        Node currentNode = head;
        Node currentNewLinkedListNode = newLinkedList.head;
        while (currentNode.next != null) {
            currentNewLinkedListNode.next = new Node(currentNode.next.getData());
            newLinkedList.setNumNodes(newLinkedList.numNodes++);
            currentNewLinkedListNode = currentNewLinkedListNode.next;
            currentNode = currentNode.next;
        }
        return newLinkedList;
    }
}
