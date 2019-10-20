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
            if (len > 0) head = (head - 1 + obj.length) % obj.length;
            obj[head] = value;
            len += 1;
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (!isFull()) {
            if (len > 0) tail = (tail + 1) % obj.length;
            obj[tail] = value;
            len += 1;
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (!isEmpty()) {
            head = (head + 1) % obj.length;
            len -= 1;
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!isEmpty()) {
            tail = (tail - 1 + obj.length) % obj.length;
            len -= 1;
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
        return len <= 0;
    }

    public boolean isFull() {
        return len >= obj.length;
    }

    public static void main(String[] args) {

        MyCircularDeque obj = new MyCircularDeque(2);
        System.out.println(obj.insertFront(7));
        System.out.println(obj.deleteLast());
        System.out.println(obj.getFront());
        System.out.println(obj.insertLast(5));
        System.out.println(obj.insertFront(0));
        System.out.println(obj.getFront());
        System.out.println(obj.getRear());
        System.out.println(obj.getFront());
        System.out.println(obj.getFront());
        System.out.println(obj.getRear());
        System.out.println(obj.insertLast(5));
    }
}
