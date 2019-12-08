package linkedlist;

public class HasCycleII {
    /*public ListNode hasCycleII(ListNode head) {
        if (head == null || head.next == null){
            reurn null;
        }

        ListNode fast = head;
        ListNode slow = head;
         while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
         }

         if (fast == null || fast.next == null)
             return null;
         slow = head;

         while (fast != slow) {
             fast = fast.next;
             slow = slow.next;
         }
         return fast;
    }*/
}
