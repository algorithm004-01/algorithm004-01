package algorithm00401

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

var ans [][]int

func levelOrder(root *TreeNode) [][]int {
	ans = make([][]int, 0)
	dfs(root, 0)
	return ans
}

func dfs(root *TreeNode, level int) {
	// recursion terminator
	if root == nil {
		retrun
	}

	// process logic in current level
	if level >= len(ans) {
		ans = append(ans, make([]int, 0))
	}
	ans[level] = append(ans[level], root.Val)

	// drill down
	dfs(root.Left, level+1)
	dfs(root.Right, level+1)
}
