/*
 * @lc app=leetcode id=61 lang=cpp
 *
 * [61] Rotate List
 *
 * https://leetcode.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (28.12%)
 * Likes:    747
 * Dislikes: 894
 * Total Accepted:    218.8K
 * Total Submissions: 776.8K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        //测试的时候首先是忘记了边界情况，例如空链表，和链表数为1的情况
        //第二是忘记处理如果翻转数很大的时候的情况，应该取模
        if (head == NULL) {
            return NULL;
        } else if (head != NULL && head->next == NULL) {
            return head;
        }
        int len = 0;
        ListNode *p = head;
        ListNode *q = p->next;
        while (p != NULL) {
            p = p->next;
            len++;
        }
        k = k % len;
        while (k != 0) {
            p = head;
            q = p->next;
            while (q->next != NULL) {
                p = q;
                q = q->next;
            }
            p->next = NULL;
            q->next = head;
            head = q;
            k--;
        }
        return head;
    }
};
// @lc code=end

