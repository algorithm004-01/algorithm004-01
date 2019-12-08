/**
 * 采用数组实现双端队列
 *  参考 java Queue，Stack
 *
 * @author tangzhenhua
 * @date 2019/10/20 20:15
 */
public class LeetCode_641_076 {

    //使用数组实现双端队列
    int[] dqueue = {};
    //头指针
    int front = 0;
    //尾指针
    int tail = 0;
    //当前大小
    int size = 0;
    //队列容量
    int capacity = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public LeetCode_641_076(int k) {

        if(k < 0){
            throw new IllegalArgumentException("param k mast >= 0");
        }

        if(k > 0){
            this.dqueue = new int[k];
            this.capacity = k;
        }

    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {

        if(isFull()){
            return false;
        }

        front = (front - 1 + capacity) % capacity;
        dqueue[front] = value;
        size ++;

        if(size == 1){
            tail = front;
        }
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }
        tail = (tail + 1) % capacity;
        dqueue[tail] = value;
        size ++;
        if(size == 1){
            front = tail;
        }
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % capacity;
        size --;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        } else {
            tail = (tail - 1 + capacity) % capacity;
            size --;
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) {
            return -1;
        } else {
            return dqueue[front];
        }
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isFull()) {
            return -1;
        }
        if(isEmpty()){
            return -1;
        }
        return dqueue[tail];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(size == 0){
            return true;
        } else {
            return false;
        }
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(size == capacity){
            return true;
        } else {
            return false;
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
    public static void main(String[] args) {
        int k = 4;
        int value = 5;
        LeetCode_641_076 obj = new LeetCode_641_076(k);
        boolean param_1 = obj.insertFront(value);
        boolean param_2 = obj.insertLast(value);
        boolean param_3 = obj.deleteFront();
        boolean param_4 = obj.deleteLast();
        int param_5 = obj.getFront();
        int param_6 = obj.getRear();
        boolean param_7 = obj.isEmpty();
        boolean param_8 = obj.isFull();
    }
}



