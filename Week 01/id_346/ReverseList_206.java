package com.yiche;

/**
 * @auther: TKQ
 * @Title: ReverseList_206
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-10-20 17:29
 */
public class ReverseList_206 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null,current = head;
        while(current!=null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
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
//memory:36.8 MB
