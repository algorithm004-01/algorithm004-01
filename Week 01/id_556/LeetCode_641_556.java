public class MyCircularDeque {

    int[] queue;
    int front;
    int rear;
    int size;
    int capacity;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.queue = new int[k];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = k;
    }

    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(3);
        System.out.println(obj.insertLast(1));
        System.out.println(obj.insertLast(2));
        System.out.println(obj.deleteFront());
        System.out.println(obj.deleteLast());
        System.out.println(obj.getFront());
        System.out.println(obj.getRear());
        System.out.println(obj.isEmpty());
        System.out.println(obj.isFull());
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            // the queue is full
            return false;
        } else {
            // compute the index
            front = (front + capacity - 1) % capacity;
            queue[front] = value;
            return true;
        }
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            // the queue is full
            return false;
        } else {
            queue[rear] = value;
            rear = (rear + 1 + capacity) % capacity;
            size++;
            return true;
        }
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            // empty
            return false;
        } else {
            front = (front + 1) % capacity;
            size--;
            return true;
        }
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            // empty
            return false;
        } else {
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;
        }
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            // empty
            return -1;
        } else {
            return queue[front];
        }
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            // empty
            return -1;
        } else {
            return queue[(rear - 1 + capacity) % capacity];
        }
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return ((rear == front) && size == 0);
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (rear == front && size == capacity);
    }
}
