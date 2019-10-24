
/**
 * Description: 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author qinxue
 * @date 2019-10-20 21:54:49
 */

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
        // 构造一个哨兵节点
        ListNode head = new ListNode(Integer.MIN_VALUE);
        // 最开始prev指针指向哨兵节点
        ListNode prev = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            // prev指针往后移动
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;

        return head.next;
    }
}