/*
 * @lc app=leetcode.cn id=145 lang=swift
 *
 * [145] 二叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (68.21%)
 * Likes:    175
 * Dislikes: 0
 * Total Accepted:    34.3K
 * Total Submissions: 50.2K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
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

    // 递归法 1
    // func postorderTraversal(_ root: TreeNode?) -> [Int] {
    //     var result = [Int]()

    //     func traverse(_ root: TreeNode?) {
    //         guard let root = root else {
    //             return
    //         }
    //         traverse(root.left)
    //         traverse(root.right)
    //         result.append(root.val)
    //     }

    //     traverse(root)

    //     return result
    // }

    // 递归法 2
    // func postorderTraversal(_ root: TreeNode?) -> [Int] {
        
    //     guard let root = root else { 
    //         return [] 
    //     }
    
    //     return postorderTraversal(root.left) + postorderTraversal(root!.right) + [root.val]
    // }

    // 迭代法 1
    // func postorderTraversal(_ root: TreeNode?) -> [Int] {
    //     var result = [Int]()

    //     var stack = [TreeNode]()
    //     var curr = root

    //     while curr != nil || !stack.isEmpty {
    //         if curr != nil {
    //             result.insert(curr!.val, at: 0)
    //             stack.append(curr!)
    //             curr = curr!.right
    //         } else {
    //             curr = stack.popLast()?.left
    //         }
        
    //     }

    //     return result
    // }

    // 迭代法 2
    func postorderTraversal(_ root: TreeNode?) -> [Int] {
        var result = [Int]()

        guard let root = root else {
            return result
        }

        var stack = [root]
        
        while !stack.isEmpty {
            let curr = stack.popLast()!
            result.insert(curr.val, at: 0)

            if let left = curr.left {
                stack.append(left)
            }

            if let right = curr.right {
                stack.append(right)
            }
        }

        return result
    }
}
// @lc code=end

