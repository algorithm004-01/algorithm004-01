package linkedlist;

public class SwapNodesPairs {
/*
    public ListNode swapNodesInPaires(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        head.next = swapNodesInPaires(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }
*/
/*
    public ListNode swapPairs(ListNode head) {
        ListNode pre = head;
        ListNode nex = pre== null?null:pre.next;
        if (nex != null) {
            head = nex;
        }
        while (pre != null && nex != null) {
            pre.next = nex.next;
            nex.next = pre;
            pre = pre.next;
            next = pre == null ? null:pre.next;
        }

        return head;
    }//错误原因是没有考虑两辆交换以后，第二个数与下一个数绑定了，简单了两辆交换不可取。
*/
    public ListNode swapPairs(ListNode head) /*{
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = cur.next.next;
        }
        return dummy.next;
    }*/
}
