class MyCircularDeque {
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        capacity_ = k;
        allocBuffer();
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (size_ == capacity_) {
            return false;
        }
        ++size_;
        buffer_[--front_idx_] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (size_ == capacity_) {
            return false;
        }
        ++size_;
        buffer_[++back_idx_] = value;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (size_ == 0) {
            return false;
        }
        --size_;
        ++front_idx_;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (size_ == 0) {
            return false;
        }
        --size_;
        --back_idx_;
        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if (size_ == 0)
            return -1;
        return buffer_[front_idx_];
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if (size_ == 0)
            return -1;
        return buffer_[back_idx_];
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return size_ == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return size_ == capacity_;
    }
private:
    void allocBuffer() {
        buffer_ = (int*)malloc(sizeof(int) * (capacity_ + 1) * 2);
        front_idx_ = capacity_;
        back_idx_ = front_idx_ - 1;
        size_ = 0;
    }
private:
    int* buffer_;
    int capacity_;
    int size_;
    int back_idx_;
    int front_idx_;
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque* obj = new MyCircularDeque(k);
 * bool param_1 = obj->insertFront(value);
 * bool param_2 = obj->insertLast(value);
 * bool param_3 = obj->deleteFront();
 * bool param_4 = obj->deleteLast();
 * int param_5 = obj->getFront();
 * int param_6 = obj->getRear();
 * bool param_7 = obj->isEmpty();
 * bool param_8 = obj->isFull();
 */
