/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

/*
 * 1. 先保存需要替换的指向的内容
 * 2. 依次修改指针个指向
 * 3. 调整新的头节点
 * */
struct ListNode* swapPairs(struct ListNode* head){
    struct ListNode dummy;
    struct ListNode *prev;
    struct ListNode* n1 = NULL;
    struct ListNode* n2 = NULL;
    struct ListNode* last = NULL;

    dummy.next = head;
    prev = &dummy;

    while (head && head->next) {
        n1 = head;
        n2 = head->next;
        last = head->next->next;

        prev->next = n2;
        n2->next = n1;
        n1->next = last;

        prev = n1;
        head = last;
    }

    return dummy.next;
}

