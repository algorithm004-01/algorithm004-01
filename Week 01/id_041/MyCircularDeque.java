class MyCircularDeque {
    int[] myDeque ;
    int front;//队头指针
    int last;//队尾指针
    int count;//队列当前的大小
    int capacity;//队列的容量

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.myDeque = new int[k];
        this.front = 0;
        this.last = 0;
        this.count = 0;
        this.capacity = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(last == front && count == capacity){
            return false;
        }else {
            myDeque[front] = value;
            front = (front+capacity-1) % capacity;
            count++;
            return true;
        }
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(last == front && count == capacity){
            return false;
        }else {
            myDeque[last] = value;
            last = (last+capacity+1) % capacity;
            count++;
            return true;
        }
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(last == front && count == 0){
            return false;
        }else {
            front = (front+1) % capacity;
            count--;
            return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(last == front && count == 0){
            return false;
        }else {
            last = (last+capacity-1) % capacity;
            count--;
            return true;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(last == front && count == 0){
            return -1;
        }else {
            return myDeque[front];
        }
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(last == front && count == 0){
            return -1;
        }else {
            return myDeque[(last+capacity-1) % capacity];
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(last == front && count == 0){
            return true;
        }else {
            return false;
        }
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(last == front && count == capacity){
            return true;
        }else {
            return false;
        }
    }
}