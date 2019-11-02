package algorithm00401

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func postorderTraversal(root *TreeNode) []int {
	if root == nil {
		return nil
	}

	traversal := make([]int, 0)
	traversal = append(traversal, postorderTraversal(root.Left)...)
	traversal = append(traversal, postorderTraversal(root.Right)...)
	traversal = append(traversal, root.Val)

	return traversal
}
