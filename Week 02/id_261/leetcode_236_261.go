// leetcode - https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree

/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *ListNode
 *     Right *ListNode
 * }
 */
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
    if root == nil {
        return nil
    }
    if root == p || root == q {
        return root
    }
    x1, x2 := lowestCommonAncestor(root.Left, p, q), lowestCommonAncestor(root.Right, p, q)
    if x1 != nil && x2 != nil {
        return root
    }
    if (x1 != nil || x2 != nil) && (root == p || root == q) {
        return root
    }
    if x1 != nil {
        return x1
    }
    if x2 != nil {
        return x2
    }
    return nil
}
