package main

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
