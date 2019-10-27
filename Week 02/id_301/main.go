package main

import "fmt"

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
中序遍历
*/
func inorderTraversal(root *TreeNode) []int {
	var res []int
	if root == nil {
		return res
	}
	if root.Left != nil {
		res = append(res, inorderTraversal(root.Left)...)
	}
	res = append(res, root.Val)
	if root.Right != nil {
		res = append(res, inorderTraversal(root.Right)...)
	}
	return res
}
func inorderTraversalByStack(root *TreeNode) []int {
	var res []int
	var nodes []*TreeNode
	if root == nil {
		return res
	}
	curr := root
	for curr != nil || len(nodes) > 0 {
		for curr != nil {
			nodes = append([]*TreeNode{curr}, nodes...)
			curr = curr.Left
		}
		curr = nodes[0]
		res = append(res, curr.Val)
		curr = curr.Right
		nodes = nodes[1:]
	}
	return res
}

/**
是否是异位词
*/
func isAnagram(s string, t string) bool {
	lenS := len(s)
	lenT := len(t)
	if lenS != lenT {
		return false
	}
	if s == "" && t == "" {
		return true
	}
	sliceS := []byte(s)
	sliceT := []byte(t)
	var charMap map[byte]int
	charMap = make(map[byte]int)
	for i := 0; i < lenS; i++ {
		charMap[sliceS[i]]++
		charMap[sliceT[i]]--
	}

	for _, v := range charMap {
		if v != 0 {
			return false
		}
	}
	return true
}

func main() {
	root := new(TreeNode)
	root.Val = 1
	root.Left = new(TreeNode)
	root.Left.Val = 2
	root.Right = new(TreeNode)
	root.Right.Val = 3

	fmt.Println(inorderTraversal(root))
}
