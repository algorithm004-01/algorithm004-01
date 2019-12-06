package simple;

/**
 * @author 潘磊明
 * @date 2019/10/22
 */
public class MergeTwoSortedLists {

    /**
     * 使用循环
     * @param l1
     * @param l2
     * @return
     */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode newHead = null;
//        ListNode cur = null;
//        while (l1 != null || l2 != null) {
//            int v1 = l1 == null ? Integer.MAX_VALUE : l1.val;
//            int v2 = l2 == null ? Integer.MAX_VALUE : l2.val;
//            if (newHead == null) {
//                newHead = new ListNode(Math.min(v1, v2));
//                cur = newHead;
//            }else {
//                cur.next = new ListNode(Math.min(v1, v2));
//                cur = cur.next;
//            }
//            if (v1 < v2) {
//                l1 = l1.next;
//            }else {
//                l2 = l2.next;
//            }
//        }
//        return newHead;
//    }

    /**
     * 使用递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
