/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (49.36%)
 * Likes:    2769
 * Dislikes: 405
 * Total Accepted:    716.3K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}
// @lc code=end


/**
 * 1-使用递归
 * l1
 *  1 → 2 → 5
 * l2
 *  0 → 3 → 4
 * 
 * 1. 0→_   1→2→5 3→4
 * 2. 0→1→_ 2→5 3→4
 * 3. 0→1→2→_ 5 3→4
 * 4. 0→1→2→3→_ 5 4
 * 5. 0→1→2→3→4→_ 5 null return 5
 * 
 */