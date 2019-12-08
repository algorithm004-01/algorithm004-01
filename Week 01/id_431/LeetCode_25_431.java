package hard;

import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/22
 */
public class ReverseNodesInK_Group {

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode tmp = head;
        //找出k+1的节点
        while (tmp != null && count != k) {
            tmp = tmp.next;
            count++;
        }
        if (count == k) {
            //迭代节点
            ListNode re = reverseKGroup(tmp, k);
            //进行交换
            while (count-- > 0){
                tmp = head.next;
                head.next = re;
                re = head;
                head = tmp;
            }
            head = re;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
