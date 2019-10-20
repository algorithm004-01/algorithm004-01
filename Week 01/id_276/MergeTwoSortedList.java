public class MergeTwoSortedList {
    /*public void mergeSortedList (List l1, List l2) {
        // 用三个指针，一个保持新链表的最后一个，一个A，一个B
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode new_Head = null;
        ListNode p = l1;
        ListNode q = l2;
        if (p.val < q.val) {
           new_head = p;
           p = p.next;
        } else {
            new_head = q;
            q = q.next;
        }
        ListNode r = new_Head;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        r.next = q==null ? p : q;
        return new_Head;
    }*/
    /*public ListNode mergeTwoList (ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }*/

}
