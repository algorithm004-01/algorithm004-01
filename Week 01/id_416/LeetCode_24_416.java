package com.first;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  *  
 *  * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedSwapPairs {
    public LinkedTable swapPairs(LinkedTable head) {
        LinkedTable prev = new LinkedTable(0);//pre,补充一次循环，达到完整通用的循环
        prev.next = head;//0.next = 1 保证完整性 0->1->2->3->4
        LinkedTable temp = prev;
        while (null != temp.next && null != temp.next.next) {
            LinkedTable first = temp.next;//1
            LinkedTable seconde = temp.next.next;//2
            seconde.next = first;//2.next---1
            temp.next = seconde;//0.next ---2
            first.next = seconde.next;//如果seconde = null，那么循环正好结束
            temp = first;
        }
        return prev.next;
    }
}
