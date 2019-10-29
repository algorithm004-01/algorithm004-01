/*
 * @lc app=leetcode.cn id=94 lang=swift
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (68.42%)
 * Likes:    310
 * Dislikes: 0
 * Total Accepted:    70.3K
 * Total Submissions: 102.5K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * 输出: [1,3,2]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */
class Solution {

    // 递归
    // func inorderTraversal(_ root: TreeNode?) -> [Int] {
        
    //     var result = [Int]()

    //     func traverse(_ root: TreeNode?) {
    //         guard let root = root else {
    //             return
    //         }
    //         traverse(root.left)
    //         result.append(root.val)
    //         traverse(root.right)
    //     }

    //     traverse(root)

    //     return result
    // }

    // 迭代
    func inorderTraversal(_ root: TreeNode?) -> [Int] {

        var result  = [Int]()
        var stack = [TreeNode]()
        var curr = root

        while curr != nil || !stack.isEmpty {
            while curr != nil {
                stack.append(curr!)
                curr = curr!.left
            }
            curr = stack.popLast()
            result.append(curr!.val)
            curr = curr!.right
        }

        return result
    }
}
// @lc code=end

