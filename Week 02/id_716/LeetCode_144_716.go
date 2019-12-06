package id_716

// https://leetcode-cn.com/problems/binary-tree-preorder-traversal
// 前序遍历

// 已经在 LeetCode_94_716.go 中定义了
// type TreeNode struct {
// 	Val int
// 	Left *TreeNode
// 	Right *TreeNode
// }

// 1. 递归遍历
func preorderTraversal1(root *TreeNode) []int {
	res := []int{}
	preorder(root, &res)
	return res
}

func preorder(node *TreeNode, res *[]int) {
	if node != nil {
		*res = append(*res, node.Val)
		preorder(node.Left, res)
		preorder(node.Right, res)
	}
}

// 2. Loop + Stack
// func preorderTraversal2(root *TreeNode) []int {
// 	return nil
// }