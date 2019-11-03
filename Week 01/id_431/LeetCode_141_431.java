package simple;

import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/21
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        //快慢节点求解
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null && slow.next != null) {
            if (fast.next.next == slow.next) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
