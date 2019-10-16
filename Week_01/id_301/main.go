package main

import (
	"algo04-01/Week_01/id_301/linklist"
	"fmt"
)

func main() {
	//nums := []int{1,2,3,4,5,6}
	//array.RotateThree(nums,2)
	//fmt.Println(nums)
	//var l1 *linklist.ListNode
	//var l2 *linklist.ListNode
	//l1 = new(linklist.ListNode)
	//l1.Val = 1
	//l1.Next = new(linklist.ListNode)
	//l1.Next.Val = 4
	//l1.Next.Next = new(linklist.ListNode)
	//l1.Next.Next.Val = 6
	//l2 = new(linklist.ListNode)
	//l2.Val = 2
	//l2.Next = new(linklist.ListNode)
	//l2.Next.Val = 3
	//l2.Next.Next = new(linklist.ListNode)
	//l2.Next.Next.Val = 7
	//fmt.Println(l1.Val)
	//fmt.Println(linklist.MergeTwoLists(l1, l2).Next.Next.Next.Next.Val)
	a1 := []int{1, 3, 9, 8, 7}
	fmt.Println(TwoSum(a1, 10))
}

/**
移除重复元素
*/
func removeDuplicates(nums []int) int {
	length := len(nums)
	index := 0
	for i := 1; i < length; i++ {
		if nums[index] != nums[i] {
			index += 1
			nums[index] = nums[i]
		}
	}
	return index + 1
}

/** 向右移动数组解法1
解法思想 ： 当一个数组长度为n，移动后k次，当k<n的时候很好理解，当k>=n的时候，其实本质上是移动了k对n求余次数
*/
func RotateOne(nums []int, k int) {
	length := len(nums)
	if length <= 1 {
		return
	}
	for i := 0; i < k; i++ {
		tmp := nums[length-1]
		for j := length - 2; j >= 0; j-- {
			nums[j+1] = nums[j]
		}
		nums[0] = tmp
	}
}

/** 向右移动数组解法2
解法思想 ： 移动次数简化同上面分析。然后我们从最数组的第一位开始，挨个一次将元素移动到目标位置，移动n次，那么所有元素都将到达最后的位置.
		  如果内层刚好移动到
*/
func RotateTwo(nums []int, k int) {
	length := len(nums)
	if length <= 1 || length == k || k == 0 {
		return
	}
	k = k % length
	count := 0
	for i := 0; count < length; i++ {
		curr := i
		pre := nums[i]
		for {
			next := (curr + k) % length
			temp := nums[next]
			nums[next] = pre
			pre = temp
			curr = next
			count++
			fmt.Println(curr, "|", i, "|", count)
			if curr == i {
				break
			}
		}
	}
}

/**
向右移动数组解法三 三次反转法
*/
func RotateThree(nums []int, k int) {
	length := len(nums)
	if length <= 1 {
		return
	}
	k = k % length
	reverseArray(nums, 0, length-1)
	reverseArray(nums, 0, k-1)
	reverseArray(nums, k, length-1)
}

/**
反转数组
*/
func reverseArray(nums []int, start, end int) {
	length := len(nums)
	if length <= 1 {
		return
	}
	if start >= end {
		return
	}
	if start > length-1 {
		start = 0
	}

	if end > length-1 {
		end = length - 1
	}
	j := end
	for i := start; i < j; i++ {
		nums[i], nums[j] = nums[j], nums[i]
		j--
	}
}

/**
合并两个有序数组 双指针从尾部开始处理数据
*/
func Merge(nums1 []int, m int, nums2 []int, n int) {
	p := m + n - 1
	p1 := m - 1
	p2 := n - 1
	for {
		if p1 < 0 {
			for ; p2 >= 0; p2-- {
				nums1[p] = nums2[p2]
				p--
			}
			break
		}
		if p2 < 0 {
			for ; p1 >= 0; p1-- {
				nums1[p] = nums1[p1]
				p--
			}
			break
		}
		if nums1[p1] > nums2[p2] {
			nums1[p] = nums1[p1]
			p1--
		} else {
			nums1[p] = nums2[p2]
			p2--
		}
		p--
	}
}

/**
两数之和
*/
func TwoSum(nums []int, target int) []int {
	var numsMap map[int]int
	numsMap = make(map[int]int)
	for k, v := range nums {
		need := target - v
		index, ok := numsMap[need]
		if ok {
			return []int{k, index}
			break
		} else {
			numsMap[v] = k
		}
	}
	return []int{}
}

/**
移动0
*/
func moveZeroes(nums []int) {
	curr := 0
	for k, v := range nums {
		if v != 0 {
			nums[curr] = v
			if curr != k {
				nums[k] = 0
			}
			curr++
		}
	}
}

/**
加一
*/
func plusOne(digits []int) []int {
	length := len(digits)
	for i := length - 1; i >= 0; i-- {
		if digits[i] != 9 {
			digits[i]++
			return digits
		} else {
			digits[i] = 0
		}
	}
	return append([]int{1}, digits...)
}

func MergeTwoLists(l1 *linklist.ListNode, l2 *linklist.ListNode) *linklist.ListNode {
	currL1 := l1
	currL2 := l2
	var res *linklist.ListNode
	res = new(linklist.ListNode)
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
	res.Next = new(linklist.ListNode)
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
		curr.Next.Next = new(linklist.ListNode)
		curr = curr.Next
	}
	return res
}
