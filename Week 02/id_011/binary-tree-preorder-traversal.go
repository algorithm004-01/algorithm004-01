package algorithm00401

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
	if root == nil {
		return nil
	}

	traversal := make([]int, 0)
	traversal = append(traversal, root.Val)
	traversal = append(traversal, preorderTraversal(root.Left)...)
	traversal = append(traversal, preorderTraversal(root.Right)...)

	return traversal
}
