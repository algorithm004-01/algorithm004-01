/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *detectCycle(struct ListNode *head) {
    if (head == NULL || head->next == NULL)
        return NULL;

    struct ListNode *fast = head;
    struct ListNode *slow = head;
    struct ListNode *meet = NULL;

    while (fast) {
        slow = slow->next;
        fast = fast->next;

        if (!fast) {
            return false;
        }

        fast = fast->next;

        if (fast == slow) {
            meet = fast;
            break;
        }
    }

    if (meet == NULL)
        return NULL;

    while (head && meet) {
        if (head == meet) {
            return head;
        }
        head = head->next;
        meet = meet->next;
    }

    return NULL;
}
