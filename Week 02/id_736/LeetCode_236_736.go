package id_736


type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	return helper(root, p, q)
}

func helper(root, p, q *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	left := helper(root.Left, p, q)
	right := helper(root.Right, p, q)
	if root == p || root == q {
		return root
	}
	if left != nil && right != nil {
		return root
	}

	if left != nil && right == nil {
		return left
	}
	if left == nil && right != nil {
		return right
	}
	return nil
}

