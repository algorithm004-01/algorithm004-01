/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {
    int[] myqueue;
    int front;
    int rear;
    int size;
    int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.myqueue = new int[k];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = k;
        
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(rear==front && size == capacity) return false;
        else {
            front = (front + capacity -1)% capacity;
            myqueue[front] = value;
            size++;
            return true;
        }
        
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(rear==front && size == capacity) return false;
        else {
            myqueue[rear] = value;
            rear = (rear+1+capacity)%capacity;
            size++;
            return true;
        }
        
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(rear == front && size == 0) return false;
        else {
            front = (front+1) % capacity;
            size--;
            return true;
        }
        
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(rear == front && size == 0) return false;
        else {
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;

        }
        
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if((rear == front) && size == 0) return -1;
        else {
            int frontE = myqueue[front];
            return frontE;
        }
        
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if((rear == front) && size==0) return -1;
        else {
            int rearE = myqueue[(rear-1+capacity)%capacity];
            return rearE;
        }
        
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return (rear == front) && size ==0;
        
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return rear == front && size == capacity;
        
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

