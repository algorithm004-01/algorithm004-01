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
广度优先遍历
*/
func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	var slice [][]*TreeNode
	slice = append(slice, []*TreeNode{root})
	var res [][]int
	for i := 0; ; i++ {
		for _, v := range slice[0] {
			if len(res) > i {
				res[i] = append(res[i], v.Val)
			} else {
				res = append(res, []int{v.Val})
			}
			slice = add(slice, v.Left)
			slice = add(slice, v.Right)
		}
		slice = slice[1:]
		if len(slice) == 0 {
			break
		}
	}
	return res
}

func add(slice [][]*TreeNode, node *TreeNode) [][]*TreeNode {
	if node == nil {
		return slice
	}
	if len(slice) > 1 {
		slice[1] = append(slice[1], node)
	} else {
		slice = append(slice, []*TreeNode{node})
	}
	return slice
}

/**
深度优先遍历
*/
func levelOrderByDFS(root *TreeNode) [][]int {
	var res [][]int

	return res
}
