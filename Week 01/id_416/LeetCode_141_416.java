package com.first;

import com.utils.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 示例 1
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedCircle {
    /**
     * 中国站上面的代码，然后自己默写的
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(null == head || null == head.next) {
            return false;//第一个元素和第二个元素如果为空，那么肯定没有环，直接返回，这个就是边界
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //以上两个为初始化，从第一个和第二个开始计算

        while(slow != fast) {//不相等，继续循环，直到快的赶上慢的
            if(fast == null || fast.next==null){
                return false;//如果走二步的任何一步为空，那么就说明没有环
            }
            slow = slow.next;//慢的走一步
            fast = fast.next.next;//快的走两步
        }
        return true;
    }

    /**
     * 国际站的代码，更简单，更容易理解，更加简洁
     * @param head
     * @return
     */
    public boolean hasCycleInternational(ListNode head) {
        int pos = -1;
        ListNode sonw = head;//慢指针
        ListNode fast = head;//快指针
        while(null != fast && null != fast.next ){//当前的快指针和当前快指针的下一个节点是否空，如果为空则没有环
            sonw = sonw.next;
            fast = fast.next.next;
            pos++;
            if(sonw == fast){

                return true;//说明有环
            }
        }
        return false;
    }
}
