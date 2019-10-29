package week02

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

// 2.1 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
func inorderTraversal(root *TreeNode) []int {

	return helper(root, []int{})
}

func helper(root *TreeNode, result  []int) []int {
	if root == nil {
		return result
	}

	var left, right []int
	if root.Left != nil {
		left = helper(root.Left, result)
	}
	if root.Right != nil {
		right = helper(root.Right, result)
	}

	result = append(result, left...)
	result = append(result, root.Val)
	result = append(result, right...)
	
	return result
}