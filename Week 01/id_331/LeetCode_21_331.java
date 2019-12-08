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
      //定义一个哨兵结点，默认值为-1
      ListNode prehead = new ListNode(-1);

      //指向哨兵结点
      ListNode prev = prehead;

      while(l1 != null && l2 != null){
        if(l1.val <= l2.val){
          prev.next = l1;
          l1 = l1.next;
        } else{
          prev.next = l2;
          l2 = l2.next;
        }

        prev = prev.next;
      }

      prev.next = l1 == null ? l2 : l1;

      return prehead.next;
    }
}