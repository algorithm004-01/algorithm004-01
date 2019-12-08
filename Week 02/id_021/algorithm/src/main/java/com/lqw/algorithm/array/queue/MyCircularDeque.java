package com.lqw.algorithm.array.queue;

/**
 * @author linqiwen
 */
class MyCircularDeque {

    /**
     * 存放元素的数组
     */
    private int[] dataArray;

    /**
     * 队列头指针
     */
    private transient int head;

    /**
     * 队列尾指针
     */
    private transient int tail;

    /**
     * 队列当前的大小
     */
    private int size;

    /**
     * 队列的容量
     */
    private int capacity;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.dataArray = new int[k];
        head = tail = 0;
        this.size = 0;
        this.capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        //如果队列满，插入失败
        if (tail == head && size == capacity) return false;
        else {
            head = (head + capacity - 1) % capacity;
            dataArray[head] = value;
            size++;
            return true;
        }

    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (tail == head && size == capacity) return false;//如果队列满，插入失败
        else {
            dataArray[tail] = value;
            tail = (tail + 1 + capacity) % capacity;
            size++;
            return true;
        }
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (tail == head && size == 0) return false;
        else {
            head = (head + 1) % capacity;
            size--;
            return true;
        }
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (tail == head && size == 0) return false;
        else {
            tail = (tail - 1 + capacity) % capacity;
            size--;
            return true;
        }
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if ((tail == head) && size == 0) return -1;
        else {
            int frontE = dataArray[head];
            return frontE;
        }
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if ((tail == head) && size == 0) return -1;
        else {
            int rearE = dataArray[(tail - 1 + capacity) % capacity];
            return rearE;
        }
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return (tail == head) && size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return tail == head && size == capacity;
    }
}

