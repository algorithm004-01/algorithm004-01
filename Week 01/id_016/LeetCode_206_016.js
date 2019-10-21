/*
 * @lc app=leetcode id=206 lang=javascript
 *
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (57.23%)
 * Likes:    2935
 * Dislikes: 73
 * Total Accepted:    712.9K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 *
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
   1.第一个是迭代的方式-从头到尾迭代                       时间O(n) 空间O(1)
   2.考虑递归的方式   -从头到尾递,尾到头归(此时指向链接操作)  时间O(n) 空间O(n) ---思想太奇妙了
 *
 */
// @lc code=start
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
// var reverseList = function(head) {
//   let temp = null;
//   let newHead = null;
//   while (head !== null) {
//     temp = head;
//     head = head.next;
//     temp.next = newHead;
//     newHead = temp;
//   }
//   return newHead;
// };
var reverseList = function(head) {
  // head === null:兼容空链表的情况
  if (head === null || head.next === null) return head; // find tail node,开始递归
  let h = reverseList(head.next); // 归的时候拿到每一个值
  head.next.next = head; // 把当前的节点指向下一个的next
  head.next = null; // 相当于尾节点置空
  return h;
};
// @lc code=end

//=====================================test=====================================
/**
 * @Description: 构造一个简单链表
 * @param {Array}
 * @return: ListNode
 */
// 构造一个简单链表
function createLinkedList(arr) {
  let list = null;
  for (let index = arr.length - 1; index >= 0; index--) {
    if (list === null) {
      list = new ListNode(arr[index]);
    } else {
      let temp = new ListNode(arr[index]);
      temp.next = list;
      list = temp;
    }
  }
  return list;
}

/**
 * @Description: 链表类
 * @param {any}
 * @return: ListNode
 */
function ListNode(val) {
  this.val = val;
  this.next = null;
}
// 构造简单链表
let list = createLinkedList([1, 2, 3, 4]);
// console.log(list);
// 反转
console.log(reverseList(list));
