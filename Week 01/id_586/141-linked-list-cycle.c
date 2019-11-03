/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

/*
 * 使用的是快慢指针的方法
 * */
bool hasCycle(struct ListNode *head) {
    struct ListNode *slow = head;
    struct ListNode *fast = head;

    if (!head || !head->next) return 0;

    while (slow && fast) {
        slow = slow->next;
        fast = fast->next;

        if (!fast)
            return 0;

        fast = fast->next;

        if (slow == fast)
            return 1;
    }

    return 0;
}
