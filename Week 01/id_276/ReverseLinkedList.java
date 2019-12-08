package linkedlist;

import java.util.List;

public class ReverseLinkedList {
    // 1.递归
     /*public ListNode reverseLinkedList(ListNode list) {
        ListNode new_head = null;

         while (list != null) {
             ListNode next = list.next;
             list.next = new_head;
             new_head = list;
             list = next;
         }
         return new_head;
     }*/
    public ListNode reveseLinkedList(ListNode head) {
        return reverseLinkedList(head, null);
    }
    /*public ListNode reverseLinkedList(ListNode head, ListNode n_head) {
        if (head == null) {
            return n_head;
        }
        ListNode next = head.next;
        head.next = n_head;
        return reveseLinkedList(next, head);
    }*/

    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        ListNode n_head = reverseLinkedList(nextNode);
        nextNode.next = head;
        head.next = null;

        return n_head;
    }

}
