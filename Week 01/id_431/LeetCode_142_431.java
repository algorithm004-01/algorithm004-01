package medium;

import simple.LinkedListCycle;

/**
 * @author 潘磊明
 * @date 2019/10/21
 */
public class LinkedListCycleII {

    /**
     * 解题思路：
     * 快慢指针，快指针每次走两步，慢指针每次走一步，
     * 当两个指针相遇时，说明快指针走过的长度为慢指针走过的2倍。
     * 又由于除了第一次相遇之后，以后的相遇就是在环里面走了，
     * 所以可以得出，慢指针第一次相遇后，离初始环节点的长度就是头结点到初始环节点的长度
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null ) return null;
        //快慢指针
        ListNode fast = head;
        ListNode slow = head;
        boolean isCircle = false;
        while (fast.next != null && fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isCircle = true;
                break;
            }

        }
        if (!isCircle) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
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
