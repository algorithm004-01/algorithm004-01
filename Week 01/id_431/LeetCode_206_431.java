package simple;


import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/21
 */
public class ReverseLinkedList {
    /**
     * 对链表进行迭代
     * @param head
     * @return
     */
//    public ListNode reverseList(ListNode head) {
//        ListNode newHead = null;
//        while (head != null) {
//            ListNode tmp = head;
//            head = head.next;
//            tmp.next = newHead;
//            newHead = tmp;
//        }
//        return newHead;
//    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        return head ==null ? head : reverseNode(head, null);
    }

    public ListNode reverseNode(ListNode src, ListNode dest){
        ListNode tmp = null;
        tmp = src;
        src = src.next;
        tmp.next = dest;
        if (src != null) {
            return reverseNode(src, tmp);
        }else{
            return tmp;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

}