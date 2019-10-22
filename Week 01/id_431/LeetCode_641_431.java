package medium;

/**
 * @author 潘磊明
 * @date 2019/10/20
 */
public class MyCircularDeque {
    private int length; //最大的长度
    private int size; //当前的节点数
    private Node head; //头部节点
    private Node tail; //尾结点

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        length = k;
        size = 0;
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) return false;
        Node node = new Node(value);
        Node tmp = head.next;
        tmp.prev = node;
        head.next = node;
        node.prev = head;
        node.next = tmp;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) return false;
        Node node = new Node(value);
        Node tmp = tail.prev;
        tmp.next = node;
        node.prev = tmp;
        node.next = tail;
        tail.prev = node;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) return -1;
        return head.next.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) return -1;
        return tail.prev.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == length;
    }

    private class Node{
        Node prev;
        Node next;
        int value;

        private Node(int value){
            this.value = value;
        }
    }
}
