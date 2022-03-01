package ss11_stack_queue.thuc_hanh.trien_khai_stack_dua_tren_mang;

public class MyStack {

    private int arr[];
    private int size;
    private int index = 0;

    public MyStack(int size) {
        this.size = size;
        arr = new int[size];
    }
    public void push(int element){
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        arr[index] = element;
        index++;
    }
    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is null");
        }
        return arr[--index];
    }
    public boolean isEmpty() {
        return index == 0;
    }
    public boolean isFull() {
        return index == size;
    }

    public int size() {
        return size;
    }
}