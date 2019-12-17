
public class Linked_MergeTowLists {
    /**
     * 递归方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null ==l1) {
            return l2;
        }
        if (null==l2) {
            return l1;
        }
        if(l1.data<l2.data){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
    
}
