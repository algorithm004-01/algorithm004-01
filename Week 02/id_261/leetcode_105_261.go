// leetcode - https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var inPos map[int]int
func buildTree(preorder []int, inorder []int) *TreeNode {
    inPos = make(map[int]int)
    for i := 0; i < len(inorder); i++ {
        inPos[inorder[i]] = i
    }
    return helper(preorder, 0, len(preorder) - 1, 0)
}


func helper(pre []int, preLeft, preRight, inStart int) *TreeNode {
    if preLeft > preRight {
        return nil 
    }
    root := &TreeNode{Val: pre[preLeft]}
    rootIndex := inPos[pre[preLeft]]
    leftLen := rootIndex - inStart
    root.Left = helper(pre, preLeft + 1, preLeft + leftLen, inStart)
    root.Right = helper(pre, preLeft + leftLen + 1, preRight, rootIndex + 1)
    return root 
}