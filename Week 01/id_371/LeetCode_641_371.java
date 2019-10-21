import java.util.Stack;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-20 09:16
 **/

public class LeetCode_641_371 {

    //通过两个栈实现双端队列
    class MyCircularDeque {
        Stack<Integer> head;
        Stack<Integer> tail;
        int size;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            head = new Stack<>();
            tail = new Stack<>();
            this.size = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (!isFull()) {
                head.push(value);
                return true;
            }
            return false;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (!isFull()) {
                tail.push(value);
                return true;
            }
            return false;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (head.isEmpty()) {
                while (!tail.isEmpty()) {
                    head.push(tail.pop());
                }
            }
            if (head.isEmpty()) {
                return false;
            } else {
                head.pop();
                return true;
            }
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (tail.isEmpty()) {
                while (!head.isEmpty()) {
                    tail.push(head.pop());
                }
            }
            if (tail.isEmpty()) {
                return false;
            } else {
                tail.pop();
                return true;
            }
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (head.isEmpty()) {
                while (!tail.isEmpty()) {
                    head.push(tail.pop());
                }
            }
            if (head.isEmpty()) {
                return -1;
            } else {
                return head.peek();
            }
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (tail.isEmpty()) {
                while (!head.isEmpty()) {
                    tail.push(head.pop());
                }
            }
            if (tail.isEmpty()) {
                return -1;
            } else {
                return tail.peek();
            }
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return head.isEmpty() && tail.isEmpty();
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return head.size() + tail.size() >= size;
        }
    }
}
