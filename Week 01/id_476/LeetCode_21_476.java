//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package com.markdown.leetcode.editor.cn;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    // class Solution {
    //     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //         if (l1 == null) return l2;
    //         if (l2 == null) return l1;
    //         ListNode main = l1, minor = l2;
    //         if (l1.val > l2.val) {
    //             main = l2;
    //             minor = l1;
    //         }
    //         ListNode head = main;
    //         while (main != null && main.next != null) {
    //             if (minor == null) {
    //                 break;
    //             }
    //             if (main.next.val > minor.val) {
    //                 ListNode mainNext = main.next;
    //                 ListNode minorNext = minor.next;
    //                 main.next = minor;
    //                 minor.next = mainNext;
    //                 if (minorNext != null && mainNext.val <= minorNext.val) {
    //                     main = mainNext;
    //                 }
    //                 minor = minorNext;
    //             } else {
    //                 main = main.next;
    //             }
    //         }
    //         if (minor != null) {
    //             main.next = minor;
    //         }
    //         return head;
    //     }
    // }

    // class Solution {
    //     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //         // 递归
    //         if (l1 == null) return l2;
    //         if (l2 == null) return l1;
    //         if (l1.val < l2.val) {
    //             l1.next = mergeTwoLists(l1.next, l2);
    //             return l1;
    //         } else {
    //             l2.next = mergeTwoLists(l1, l2.next);
    //             return l2;
    //         }
    //     }
    // }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 迭代
            ListNode prehead = new ListNode(-1);
            ListNode prev = prehead;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }
            prev.next = l1 != null ? l1 : l2;
            return prehead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}