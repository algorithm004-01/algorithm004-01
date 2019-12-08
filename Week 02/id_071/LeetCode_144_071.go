package week02

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

// 2.2 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
func preorderTraversal(root *TreeNode) []int {
    
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
    result = append(result, root.Val)
	result = append(result, left...)
	result = append(result, right...)
	
	return result
}