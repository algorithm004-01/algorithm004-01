package com.yiche.mapi.cargoods;

/**
 * @auther: TKQ
 * @Title: SwapParis
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-10-19 13:33
 */
public class SwapParis_24 {

    public ListNode swapPairs(ListNode head) {
        if(head == null||head.next == null){
            return head;
        }
        ListNode current = head,next = head.next;
        current.next = swapPairs(next.next);
        next.next = current;
        return next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
