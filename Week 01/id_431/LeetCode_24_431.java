package medium;

import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/21
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode newHead = new ListNode(0); //哨兵节点用于占位
        swapNode(newHead, head);
        return newHead.next;
    }

    public void swapNode(ListNode head, ListNode swapNode){
        if (swapNode != null && swapNode.next != null) {
            ListNode tmp = swapNode.next.next;
            head.next = swapNode.next;
            head.next.next = swapNode;
            swapNode = tmp;
            swapNode(head.next.next, swapNode);
        }else{
            head.next = swapNode;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
