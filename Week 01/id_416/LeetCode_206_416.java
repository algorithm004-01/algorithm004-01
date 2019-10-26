package com.first;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedReverse {

    //while
    public LinkedTable reverseList(LinkedTable head){
        LinkedTable prev = null;//临时记录上一个对象
        LinkedTable curr = head;
        while (null != curr) {
            LinkedTable linkedTable = curr.next;
            curr.next = prev;
            prev = curr;
            curr = linkedTable;
        }
        return prev;
    }
    //reverse
    public LinkedTable reverseList1(LinkedTable head,LinkedTable prev) {
        if(null != head){
            LinkedTable tempNext = head.next;

            head.next = prev;

            prev = head;

            reverseList1(tempNext,prev);
        }
        return prev;
    }


//    public static void main(String[] args) {
//        LinkedTable linkedTable0 = new LinkedTable(new String("1"));
//        LinkedTable linkedTable1= new LinkedTable(new String("2"));
//        LinkedTable linkedTable2 = new LinkedTable(new String("3"));
//        linkedTable0.next = linkedTable1;
//        linkedTable1.next = linkedTable2;
//        linkedTable2.next = null;
//
//        LinkedTable temp = linkedTable0;
//        while (true) {
//            System.out.println(temp.val);
//            if(null == temp.next){
//                break;
//            }
//            temp = temp.next;
//        }
//
//
//        LinkedReverse reverseLinkedTable = new LinkedReverse();
//        reverseLinkedTable.reverseList1(linkedTable0,null);
//
//        LinkedTable temp12 = linkedTable2;
//        while (true) {
//            System.out.println(temp12.val);
//            if(null == temp12.next){
//                break;
//            }
//            temp12 = temp12.next;
//        }

//    }



    
}
