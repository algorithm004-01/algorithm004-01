/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
function ListNode(val) {
  this.val = val;
  this.next = null;
}
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function(head) {
  if (!head || !head.next) return null;
  let slow = head;
  let fast = head;
  while (fast && fast.next) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow === fast) {
      fast = head;
      while (slow !== fast) {
        slow = slow.next;
        fast = fast.next;
      }
      return fast;
    }
  }
  // fast = head;
  // while (slow !== fast) {
  //   slow = slow.next;
  //   fast = fast.next;
  // }
  // return fast;
  return null;
};

let a = new ListNode(1);
let b = new ListNode(2);
let c = new ListNode(3);
let d = new ListNode(4);

a.next = b;
b.next = c;
c.next = d;
d.next = b;

detectCycle(a);