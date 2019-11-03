/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

/* 1. 使用一个 new_head 作为翻转链表的头指针的，遍历给定的链表，
 * 2. 把遍历的元素使用头插的方法，插入链表，
 * 3. 返回 new_head */
struct ListNode* reverseList(struct ListNode* head){
    struct ListNode *new_head = NULL;

    while (head) {
        struct ListNode *tmp = head;
        head = head->next;
        tmp->next = new_head;
        new_head = tmp;
    }

    return new_head;
}

