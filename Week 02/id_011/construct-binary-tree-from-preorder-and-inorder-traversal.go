package algorithm00401

func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 || len(inorder) == 0 {
		return nil
	}

	root := &TreeNode{Val: preorder[0]}
	mid := findIndex(inorder, preorder[0])

	root.Left = buildTree(preorder[1:mid+1], inorder[:mid])
	root.Right = buildTree(preorder[mid+1:], inorder[mid+1:])

	return root
}

func findIndex(nums []int, value int) int {
	for i := 0; i < len(nums); i++ {
		if nums[i] == value {
			return i
		}
	}
	return -1
}
