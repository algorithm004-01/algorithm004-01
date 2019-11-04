package main

import (
	"fmt"
	"strings"
)

// Solution 1: Recursive Assignment.
// The code is much cleaner but not recommended in production code,
// which will cause stack overflow if the list is too long.
// Time Complexity : O(M+N)
// Space Complexity: O(1)
func mergeTwoListsRecursion(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}

	if l1.Val < l2.Val {
		l1.Next = mergeTwoListsRecursion(l1.Next, l2)
		return l1
	} else {
		l2.Next = mergeTwoListsRecursion(l1, l2.Next)
		return l2
	}
}

// Solution 2: Interative Loop.
// Use a dummy node to simplify the interactive loop.
// Time Complexity : O(M+N)
// Space Complexity: O(1)
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	dummy := &ListNode{}
	curr := dummy

	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			curr.Next = l1
			l1 = l1.Next
		} else {
			curr.Next = l2
			l2 = l2.Next
		}

		curr = curr.Next
	}

	if l1 == nil {
		curr.Next = l2
	} else {
		curr.Next = l1
	}

	return dummy.Next
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func (l *ListNode) String() string {
	if l == nil {
		return ""
	}

	var b strings.Builder
	if l != nil {
		b.WriteString(fmt.Sprintf("%d", l.Val))
	}

	for node := l.Next; node != nil; node = node.Next {
		b.WriteString(fmt.Sprintf("->%d", node.Val))
	}

	return b.String()
}

func main() {
	l1 := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val: 4,
			},
		},
	}

	l2 := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 3,
			Next: &ListNode{
				Val: 4,
			},
		},
	}

	fmt.Println(mergeTwoLists(l1, l2))
}
