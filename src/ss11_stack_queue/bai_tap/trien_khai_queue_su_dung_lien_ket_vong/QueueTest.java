package ss11_stack_queue.bai_tap.trien_khai_queue_su_dung_lien_ket_vong;

public class QueueTest {

    public static void main(String[] args) {

        Queue queue = new Queue(3,5,6,9);

        System.out.println("Khởi tạo Queue");
        queue.displayQueue();

        System.out.println("Sau khi enQueue(4)");
        queue.enQueue(4);
        queue.displayQueue();

        System.out.println("Sau khi deQueue() 4 lần");
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.displayQueue();

        System.out.println("Sau khi deQueue() phần tử cuối");
        queue.deQueue();
        queue.displayQueue();

    }
}
