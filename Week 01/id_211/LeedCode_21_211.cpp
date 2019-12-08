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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (!l1 && l2)
            return l2;
        if (!l2 && l1)
            return l1;
        
        if (!l1 && !l2)
            return nullptr;
        
        ListNode *lc, *tail, *p1, *p2;
        lc = tail = l1;
        p1 = l1;
        p2 = l2;
        
        if (p1->val > p2->val) {
            lc = tail = p2;
            p2 = p2->next;
        } else {
            p1 = p1->next;
        }
        
        while (p1 != nullptr && p2 != nullptr) {
            if (p1->val > p2->val) {
                tail->next = p2;
                tail = p2;
                p2 = p2->next;
            } else {
                tail->next = p1;
                tail = p1;
                p1 = p1->next;
            }
        }
        
        if (p1 == nullptr) {
            tail->next = p2;
            tail = p2;
        }
        
        if (p2 == nullptr) {
            tail->next = p1;
            tail = p1;
        }
        
        return lc;        
    }
};
