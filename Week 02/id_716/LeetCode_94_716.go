package id_716

// https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
// 树的中序遍历

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

// 1. 使用递归的方式做中序遍历
func inorderTraversal1(root *TreeNode) []int {
	res := []int{}
    inorder(root, &res)
    return res
}

// 中序递归
func inorder(node *TreeNode, res *[]int) {
    if node != nil {
        if node.Left != nil {
            inorder(node.Left, res)
        }
        *res = append(*res, node.Val)
        if node.Right != nil {
            inorder(node.Right, res)
        }
    }
}

// 2. 非递归方式，模拟中序递归遍历的过程
// func inorderTraversal2(root *TreeNode) []int {
// 	res := []int{}

// 	curr := root
// 	s := NewLinkedStack()
// 	for curr != nil || !s.isEmpty() {
// 		if curr.Left != nil {
// 			s.Push(curr)
// 			root = root.Left
// 		}

// 		if s.isEmpty() {
// 		}
// 	}
// 	return res
// }
