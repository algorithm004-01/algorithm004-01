/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
  let prev = null;
  while (head) {
    let cur = head;
    head = cur.next;
    cur.next = prev;
    prev = cur;
  }
  return prev;
};
