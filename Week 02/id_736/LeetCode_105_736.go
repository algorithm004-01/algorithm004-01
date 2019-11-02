package id_736


type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}
	res := &TreeNode{
		Val: preorder[0],
	}
	if len(preorder) == 1 {
		return res
	}
	idx := func(val int, nums []int) int {
		for i, v := range nums {
			if v == val {
				return i
			}
		}
		return -1
	}(res.Val, inorder)
	if idx == -1 {
		return nil
	}
	res.Left = buildTree(preorder[1:idx+1], inorder[:idx])
	res.Right = buildTree(preorder[idx+1:], inorder[idx+1:])
	return res
}