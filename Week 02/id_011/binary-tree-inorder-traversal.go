package algorithm00401

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func inorderTraversal(root *TreeNode) []int {
	if root == nil {
		return nil
	}

	traversal := make([]int, 0)
	traversal = append(traversal, inorderTraversal(root.Left)...)
	traversal = append(traversal, root.Val)
	traversal = append(traversal, inorderTraversal(root.Right)...)

	return traversal
}
