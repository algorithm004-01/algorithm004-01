func inorderTraversal(root *TreeNode) []int {
    if root == nil {
        return []int{}
    }
    
	arr := make([]int, 0)
	
    arr = append(arr, inorderTraversal2(root.Left)...)
    
    arr = append(arr, root.Val)
    
    arr = append(arr, inorderTraversal2(root.Right)...)
    
    return arr
}