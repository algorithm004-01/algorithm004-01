import java.util.HashSet;

import com.sun.tools.javac.util.List;

/**
 * _141LinkedListCycle
 */

 /**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class _141LinkedListCycle {
    //1. 暴力法,时间复杂度on，空间复杂度on，遍历链表，用hash/set存遍历过的元素，判断是否优重复
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
    // 2. 套路办法：快慢指针O(1)的空间复杂度
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
    
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
} 