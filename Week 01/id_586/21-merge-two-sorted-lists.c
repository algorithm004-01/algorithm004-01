/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    if (!l1) return l2;
    if (!l2) return l1;
    
    struct ListNode dummy;
    struct ListNode *prev = &dummy;

    while (l1 && l2) {
        if (l1->val < l2->val) {
            prev->next = l1;
            l1 = l1->next;
        } else {
            prev->next = l2;
            l2 = l2->next;
        }

        prev = prev->next;
    }

    if (l1)
        prev->next = l1;
    if (l2)
        prev->next = l2;

    return dummy.next;
} 
