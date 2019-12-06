/*
 * @lc app=leetcode.cn id=144 lang=swift
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (62.09%)
 * Likes:    163
 * Dislikes: 0
 * Total Accepted:    46.6K
 * Total Submissions: 74.7K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
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
 * 输出: [1,2,3]
 * 
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
    // func preorderTraversal(_ root: TreeNode?) -> [Int] {
    //     var result = [Int]()

    //     func traverse(_ root: TreeNode?) {
    //         guard let root = root else {
    //             return
    //         }
    //         result.append(root.val)
    //         traverse(root.left)
    //         traverse(root.right)
    //     }

    //     traverse(root)

    //     return result
    // }

    // 迭代法
    // func preorderTraversal(_ root: TreeNode?) -> [Int] {
    //     var result = [Int]()

    //     var stack = [TreeNode]()
    //     var curr = root

    //     while curr != nil || !stack.isEmpty {
    //         while curr != nil {
    //             result.append(curr!.val)
    //             // if let right = curr!.right {
    //             //     stack.append(right)
    //             // }
    //             stack.append(curr!)
    //             curr = curr!.left
    //         }
    //         // curr = stack.popLast()
    //         curr = stack.popLast()?.right
    //     }

    //     return result
    // }

    // 迭代法
    func preorderTraversal(_ root: TreeNode?) -> [Int] {
        var result = [Int]()

        guard let root = root else {
            return result
        }

        var stack = [root]
        
        while !stack.isEmpty {
            let curr = stack.popLast()!
            result.append(curr.val)

            if let right = curr.right {
                stack.append(right)
            }

            if let left = curr.left {
                stack.append(left)
            }
        }

        return result
    }
}
// @lc code=end

