// leetcode - https://leetcode-cn.com/problems/merge-two-sorted-lists/

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
    head := &ListNode{}
    list := head
    for l1 != nil || l2 != nil {
        if l1 == nil {
            list.Next = &ListNode{Val: l2.Val}
            l2 = l2.Next
        } else if l2 == nil {
            list.Next = &ListNode{Val: l1.Val}
            l1 = l1.Next
        } else if l1.Val <= l2.Val {
            list.Next = &ListNode{Val: l1.Val}
            l1 = l1.Next
        } else {
            list.Next = &ListNode{Val: l2.Val}
            l2 = l2.Next
        }
        list = list.Next
    }
    return head.Next
}