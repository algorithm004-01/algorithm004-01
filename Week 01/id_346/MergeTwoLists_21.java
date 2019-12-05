package com.yiche.mapi;

/**
 * @auther: TKQ
 * @Title: MergeTwoLists_21
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-10-20 17:23
 */
public class MergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
//runtime:0 ms
//memory:37.7 MB
