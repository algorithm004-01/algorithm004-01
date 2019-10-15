package main

import (
	"algo04-01/Week_01/id_301/array"
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
	a1 := []int{1, 3, 9, 0, 0, 0, 0, 0}
	a2 := []int{2, 5, 6}
	array.Merge(a1, 3, a2, 3)
	fmt.Println(a1)
}
