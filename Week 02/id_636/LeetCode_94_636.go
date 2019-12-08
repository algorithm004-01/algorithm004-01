package id_636


// Definition for a binary tree node.
type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	// check root whether root is nil
	if root == nil {
		return nil
	}

	// if root left is nil and right is nil
	// return []
	if root.Left == nil && root.Right == nil {
		return []int{root.Val}
	}

	// result
	result := inorderTraversal(root.Left)
	result = append(result, root.Val)
	result = append(result, inorderTraversal(root.Right)...)

	return result
}
