package ss10_arraylist.bai_tap.trien_khai_arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> /*extends ArrayList */ {

    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    /* hàm khởi tạo mặc định với độ lớn là DEFAULT_CAPACITY
     * */
    MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /* hàm khởi tạo với tham số là độ lớn
     * @param capacity
     * */
    MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity " + capacity);
        }
    }

    int size() {
        return size;
    }

    void clear() {
        size = 0;
        Arrays.fill(elements, null);
    }

    boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(5);
        }
        elements[size++] = element;
        return true;
    }

    void add(int index, E element) {
        if (index > elements.length || index < 0) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
//            dịch chuyển phần từ i - 1 cho i (bắt đầu từ size + 1 kết thúc tại index)
            for (int i = size; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
//            if (size + 1 - index >= 0)
//                System.arraycopy(elements, index - 1, elements, index, size + 2 - index);
            elements[index] = element;
            size++;
        }

    }

    void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity: " + minCapacity);
        }
    }

    E get(int index) {
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("index " + index);
        } else {
            return (E) elements[index];
        }
    }

    int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    boolean contains(E o) {
        return this.indexOf(o) != -1;
    }

    public MyList<E> clone() {
        MyList<E> newMyList = new MyList<>();
        newMyList.elements = Arrays.copyOf(this.elements, this.size);
        newMyList.size = this.size;
        return newMyList;
    }

    E remove(int index) {
        E removedItem = this.get(index);
        if (size - 1 - index >= 0) {
            System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        }
        elements[size - 1] = null;
        size--;
        return removedItem;
    }
}
