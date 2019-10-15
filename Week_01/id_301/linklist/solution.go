package linklist

func MergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	currL1 := l1
	currL2 := l2
	var res *ListNode
	res = new(ListNode)
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	if currL1.Val > currL2.Val {
		res.Val = currL2.Val
		currL2 = currL2.Next
	} else {
		res.Val = currL1.Val
		currL1 = currL1.Next
	}
	res.Next = new(ListNode)
	curr := res
	for {
		if currL1 == nil {
			curr.Next = currL2
			break
		}
		if currL2 == nil {
			curr.Next = currL1
			break
		}
		if currL1.Val > currL2.Val {
			curr.Next.Val = currL2.Val
			currL2 = currL2.Next
		} else {
			curr.Next.Val = currL1.Val
			currL1 = currL1.Next
		}
		curr.Next.Next = new(ListNode)
		curr = curr.Next
	}
	return res
}
