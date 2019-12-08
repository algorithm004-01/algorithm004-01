package id531

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	if l1.Val < l2.Val {
		l1.Next = mergeTwoLists(l1.Next, l2)
		return l1
	} else {
		l2.Next = mergeTwoLists(l1, l2.Next)
		return l2
	}
}

func twoSum(nums []int, target int) []int {
	cache := make(map[int]int)
	for i, v1 := range nums {
		cache[v1] = i
	}
	for j, v1 := range nums {
		complete := target - v1
		if index, ok := cache[complete]; ok {
			if index != j {
				return []int{j, index}
			}
		}
	}
	return nil
}
