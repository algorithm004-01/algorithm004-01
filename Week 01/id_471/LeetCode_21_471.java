//借助两个临时变量结点，newNode为头结点，tail为尾节点，然后遍历两个链表，按照从小到大的顺序通过tail链接。最后得到的newNode即为新的合并链表的头结点
//时间复杂度O ( l1.length + l2.length )
//空间复杂度：O(1)

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(-1);
        ListNode tail = newNode;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
                tail = tail.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
                tail = tail.next;
            }
        }
        if(l1 != null){
            tail.next = l1;
        }
        if(l2 != null){
            tail.next = l2;
        }
        return newNode.next;
    }
}