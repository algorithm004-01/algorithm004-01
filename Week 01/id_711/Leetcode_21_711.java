package Week1;

public class Lettcode_021 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(2);
        ListNode r3 = new ListNode(3);
        r1.next = r2;
        r2.next = r3;

        ListNode list = mergeTwoLists(l1,r1);
        while (list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
    }

    /**
     * 模拟即可
     * 执行用时 :1 ms, 在所有 java 提交中击败了94.36%的用户
     * 内存消耗 :39.8 MB, 在所有 java 提交中击败了66.20%的用户
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
                pre = pre.next;
            }
            else{
                pre.next = l2;
                l2 = l2.next;
                pre = pre.next;
            }
        }
        pre.next = l1 == null ? l2 : l1;
        return head.next;
    }


}
