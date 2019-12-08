package linkedlist;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dumm.next = head;
        ListNode pre = dummy;
        ListNode tail = head;

        while (tail.next != null) {
            for (int i=0;i<k&&tail!=null;++i)
                tail = tail.next;
            if (tail == null)
                break;
            ListNode start = pre.next;
            ListNode nex = tail.next;
            tail.next = null;
            pre.next = reverse(start);
            start.next = mex;
            pre = start;
            tail.next = pre;
        }
        return dummy;
    }
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
