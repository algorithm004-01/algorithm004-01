/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-15 20:16
 **/

public class LeetCode_21_371 {
    class ListNode {
        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        int val;
        ListNode next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        //1.设置前置节点,方便返回链表
        //preHead节点不变
        ListNode head = new ListNode(-1);

        //通过tail节点来记录新链表的尾部
        ListNode tail = head;

        //2.遍历两个链表
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        //3.将剩下没有遍历的链表指向新链表的尾部
        tail.next = l1 == null ? l2 : l1;

        return head.next;
    }


    /**
     * 原始解,没解完
     * 原因:对链表的理解没透彻,只想到一个一个节点读链表,而忘记链表最大的优势就是改变指针指向来完成数据交互
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //1.新建一个链表
        ListNode newNode = new ListNode();
        //2.同时读读两个链表,谁小用谁
        while (l1.next != null && l2.next != null) {
            if (l1.val <= l2.val) {
                newNode.val = l1.val;
                l1 = l1.next;
            } else {
                newNode.val = l2.val;
                l2 = l2.next;
            }
            newNode = newNode.next;
        }
        if (l1.next == null) {

            while (l2.next != null) {
                newNode.val = l2.val;
                newNode = newNode.next;
            }


        }
        while (l1.next != null) {
            newNode.val = l1.val;
            newNode = newNode.next;
        }


        return newNode;
    }


}
