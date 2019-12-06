package id_531

//PostOrderTraversal  二叉树后续遍历
func PostOrderTraversal(root *TreeNode) []int {

	var res []int
	helper2(root, &res)
	return res

}

func helper2(root *TreeNode, res *[]int) {
	//terminal
	if root != nil {
		if root.Left != nil {
			helper(root.Left, res)
		}
		if root.Right != nil {
			helper(root.Right, res)
		}
		*res = append(*res, root.Val)
	}
}
