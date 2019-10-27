/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {

    private int[] objects;
    private int head;
    private int tail;
    private int MAX_SIZE;
    private int length;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        objects = new int[k];
        head = tail = -1;
        MAX_SIZE = k;
        length = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertFront(int value) {
        if (isFull())
            return false;
        head = (head - 1 + MAX_SIZE) % MAX_SIZE;
        objects[head] = value;
        length++;
        if (length == 1) {
            tail = head;
        }
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertLast(int value) {
        if (isFull())
            return false;
        tail = (tail + 1) % MAX_SIZE;
        objects[tail] = value;
        length++;
        if (length == 1) {
            head = tail;
        }
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteFront() {
        if (isEmpty())
            return false;
        head = (head + 1) % MAX_SIZE;
        length--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        tail = (tail - 1 + MAX_SIZE) % MAX_SIZE;
        length--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty())
            return -1;
        return objects[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty())
            return -1;
        return objects[tail];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return length == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return length == MAX_SIZE;
    }

}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

