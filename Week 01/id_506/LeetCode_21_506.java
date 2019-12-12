/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(-1);

        ListNode prev = head;


        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                prev.next = l2;
                l2 = l2.next;


            }else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }

        if (l2 != null){
            prev.next = l2;
        }

        if (l1 != null){
            prev.next = l1;
        }

        return head.next;
    }
}