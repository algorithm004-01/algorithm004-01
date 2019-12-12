package com.mrglint.leetcode.solution641;

/**
 * 使用数组实现的循环双端队列。
 * 要点：在头部入队时，需要考虑边界条件0的情况，因此使用(head - 1 + length) % length来计算头部入队后head的索引位置；同理，在尾部出队时使用(tail - 1 + length) % length来计算tail的索引位置
 * @author luhuancheng
 * @since 2019-10-19 16:20
 */
public class MyCircularDeque {

    private int[] store;
    private int head, tail;
    private int length;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        length = k + 1;
        store = new int[length];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = (head - 1 + length) % length;
        store[head] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        store[tail] = value;
        tail = (tail + 1) % length;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % length;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail - 1 + length) % length;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return store[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return store[(tail - 1 + length) % length];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return tail == head;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (tail + 1) % length == head;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertFront(9));
        System.out.println(myCircularDeque.getRear());
    }
}

