package simple;

/**
 * @author 潘磊明
 * @date 2019/10/22
 */
public class MinStack {
    Node head; //头结点
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        head = new Node(Integer.MAX_VALUE);
        min = head.val;
    }

    public void push(int x) {
        Node tmp = new Node(x);
        if (x <= min) {
            Node minNode = new Node(min);
            minNode.next = head.next;
            head.next = minNode;
            min = x;
        }
        tmp.next = head.next;
        head.next = tmp;
    }

    public void pop() {
        if (head.next != null) {
           if (head.next.val == min) {
               min = head.next.next.val;
               head.next = head.next.next.next;
           }else {
               head.next = head.next.next;
           }
        }
    }

    public int top() {
        return head.next.val;
    }

    public int getMin() {
        return min;
    }

    class Node {
        int val;
        Node next;

        Node (int val) {
            this.val = val;
        }
    }
}
