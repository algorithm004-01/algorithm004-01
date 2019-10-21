package id_716

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
type ListNode struct {
	Val int
	Next *ListNode
}

// 1
func mergeTwoLists1(l1 *ListNode, l2 *ListNode) *ListNode {
	// check range
	if l1 == nil && l2 == nil { return nil }
	if l1 == nil && l2 != nil { return l2 }
	if l1 != nil && l2 == nil { return l1 }

    head := l1
	if l1.Val > l2.Val {
		head = l2
	}

	for l1 != nil && l2 != nil {
		if l1.Val <= l2.Val {
			// 在 l1 中找到一个合适的位置插入 l2 的元素
			for l1.Next != nil && l1.Next.Val < l2.Val {
				l1 = l1.Next
			}

			// move ptr
			tmp1 := l1.Next
			l1.Next = l2
			l2 = l2.Next
			l1.Next.Next = tmp1
		} else {
			// 在 l2 中找到一个合适的位置插入 l1 的元素
			for l2.Next != nil && l2.Next.Val < l1.Val {
				l2 = l2.Next
			}

			// move ptr
			tmp2 := l2.Next
			l2.Next = l1
			l1 = l1.Next
			l2.Next.Next = tmp2
		}
	}

	return head
}

// 2 另外一种代码实现
func mergeTwoLists2(l1 *ListNode, l2 *ListNode) *ListNode {
	// 前置节点，用来指向新链表
	head := &ListNode{Next: nil}
	// 记录已经排好序列表的最后位置
	prev := head

	for l1 != nil && l2 != nil {
		if l1.Val <= l2.Val {
			prev.Next = l1
			l1 = l1.Next
		} else {
			prev.Next = l2
			l2 = l2.Next
		}

		prev = prev.Next
	}

	if l1 != nil { prev.Next = l1 }
	if l2 != nil { prev.Next = l2 }

	return head.Next
}
