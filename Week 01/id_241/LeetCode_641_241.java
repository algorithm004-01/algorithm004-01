/**
 * 设计循环双端队列(共三种实现方法)
 */
//基于数组拷贝的实现
public class MyCircularDeque {
    private int max;
    private int[] obj = new int[0];

    public MyCircularDeque(int k) {
        this.max = k;
    }

    public boolean insertFront(int value) {
        if (!isFull()) {
            int[] newObj = new int[obj.length + 1];
            if (!isEmpty())
                System.arraycopy(obj, 0, newObj, 1, obj.length);
            newObj[0] = value;
            this.obj = newObj;
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (!isFull()) {
            int[] newObj = new int[obj.length + 1];
            if (!isEmpty())
                System.arraycopy(obj, 0, newObj, 0, obj.length);
            newObj[obj.length] = value;
            this.obj = newObj;
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (!isEmpty()) {
            int[] newObj = new int[obj.length - 1];
            if (obj.length > 1)
                System.arraycopy(obj, 1, newObj, 0, obj.length - 1);
            obj = newObj;
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!isEmpty()) {
            int[] newObj = new int[obj.length - 1];
            if (obj.length > 1)
                System.arraycopy(obj, 0, newObj, 0, obj.length - 1);
            obj = newObj;
            return true;
        }
        return false;
    }

    public int getFront() {
        return isEmpty() ? -1 : obj[0];
    }

    public int getRear() {
        return isEmpty() ? -1 : obj[obj.length - 1];
    }

    public boolean isEmpty() {
        return obj.length == 0;
    }

    public boolean isFull() {
        return obj.length == max;
    }
}

//基于链表的实现
class MyCircularDeque2 {

    private int capacity, size;
    private Node head;
    private Node tail;

    public MyCircularDeque2(int k) {
        this.capacity = k;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node newFirst = new Node(value);
        Node oldFirst = head.next;
        head.next = newFirst;
        newFirst.prev = head;
        oldFirst.prev = newFirst;
        newFirst.next = oldFirst;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        Node newLast = new Node(value);
        Node oldLast = tail.prev;
        tail.prev = newLast;
        newLast.next = tail;
        newLast.prev = oldLast;
        oldLast.next = newLast;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        Node first = head.next;
        head.next = first.next;
        first.next.prev = head;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        Node last = tail.prev;
        tail.prev = last.prev;
        last.prev.next = tail;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : head.next.value;
    }

    public int getRear() {
        return isEmpty() ? -1 : tail.prev.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    static class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}

//基于数组指针移动的实现
public class MyCircularDeque3 {

    private int head;
    private int tail;
    private int len;
    private int[] obj;

    public MyCircularDeque3(int k) {
        this.obj = new int[k];
    }

    public boolean insertFront(int value) {
        if (!isFull()) {
            if (!isEmpty()) head = (head - 1 + obj.length) % obj.length;
            obj[head] = value;
            len++;
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (!isFull()) {
            if (!isEmpty()) tail = (tail + 1) % obj.length;
            obj[tail] = value;
            len++;
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (!isEmpty()) {
            if (len > 1) head = (head + 1) % obj.length;
            len--;
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!isEmpty()) {
            if (len > 1) tail = (tail - 1 + obj.length) % obj.length;
            len--;
            return true;
        }
        return false;
    }

    public int getFront() {
        return isEmpty() ? -1 : obj[head];
    }

    public int getRear() {
        return isEmpty() ? -1 : obj[tail];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == obj.length;
    }
}
