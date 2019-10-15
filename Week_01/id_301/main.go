package main

import (
	"algo04-01/Week_01/id_301/linklist"
	"fmt"
)

func main() {
	//nums := []int{1,2,3,4,5,6}
	//array.RotateThree(nums,2)
	//fmt.Println(nums)
	var l1 *linklist.ListNode
	var l2 *linklist.ListNode
	l1 = new(linklist.ListNode)
	l1.Val = 1
	l1.Next = new(linklist.ListNode)
	l1.Next.Val = 4
	l1.Next.Next = new(linklist.ListNode)
	l1.Next.Next.Val = 6
	l2 = new(linklist.ListNode)
	l2.Val = 2
	l2.Next = new(linklist.ListNode)
	l2.Next.Val = 3
	l2.Next.Next = new(linklist.ListNode)
	l2.Next.Next.Val = 7
	//fmt.Println(l1.Val)
	fmt.Println(linklist.MergeTwoLists(l1, l2).Next.Next.Next.Next.Val)
}
