package vip.ruoyun;

public class Leetcode641 {

    private int[] deque;
    private int head;//指针
    private int tail;//尾指针
    private int maxSize;//最大值
    private int count;//当前的容量

    public Leetcode641(int k) {
        count = 0;
        maxSize = k;
        deque = new int[k];
        head = 0;
        tail = 0;
    }

    //将一个元素添加到双端队列头部。 如果操作成功返回 true。
    public boolean insertFront(int value) {
        if (count >= maxSize) {
            return false;
        }
        //添加
        deque[head] = value;
        head = maxSize - 1 - head;
        count++;
        return true;
    }

    //将一个元素添加到双端队列尾部。如果操作成功返回 true。
    public boolean insertLast(int value) {
        if (count >= maxSize) {
            return false;
        }
        //添加
        tail = (tail + 1) % maxSize;
        deque[tail] = value;
        count++;
        return true;
    }

    //从双端队列头部删除一个元素。 如果操作成功返回 true
    public boolean deleteFront() {
        if (count == 0) {
            return false;
        }
        head = (head + 1) % maxSize;
        count--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (count == 0) {
            return false;
        }
        tail = (tail - 1);
        if (tail < 0) {
            tail = tail + maxSize;
        }
        count--;
        return true;
    }

    public int getFront() {
        if (count == 0) {
            return -1;
        }
        return deque[head];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (count == 0) {
            return -1;
        }
        return deque[tail];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        if (count == maxSize) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode641 circularDeque = new Leetcode641(3); // 设置容量大小为3
        circularDeque.insertLast(1);                    // 返回 true
        circularDeque.insertLast(2);                    // 返回 true
        circularDeque.insertLast(2);                    // 返回 true
        circularDeque.insertLast(2);                    // 返回 true
//        circularDeque.insertFront(3);                    // 返回 true
//        circularDeque.insertFront(4);                    // 已经满了，返回 false
//        circularDeque.getRear();                // 返回 2
//        circularDeque.isFull();                        // 返回 true
//        circularDeque.deleteLast();                    // 返回 true
//        circularDeque.insertFront(4);                    // 返回 true
//        circularDeque.getFront();
    }
}

//卡在一个问题中: