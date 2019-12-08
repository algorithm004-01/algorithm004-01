//
//  LeetCode_242_396.swift
//  
//
//  Created by chenjunzhi on 2019/10/27.
//

import UIKit
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

//二叉树前序遍历
class Solution {
    func preorderTraversal(_ root: TreeNode?) -> [Int] {
        guard let tree = root else {
            return []
        }
        
        var current:TreeNode!
        var result : [Int] = []
        var stack: [TreeNode] = [tree]
        while stack.count > 0 {
            //遍历当前节点
            current = stack.last
            result.append(current.val)
            stack.removeLast()
            //右节点进入栈底
            if let right = current.right {
                stack.append(right)
            }
            //再左节点进入栈
            if let left = current.left {
                stack.append(left)
            }
        }
        return result
    }
    
    // func preorderTraversal(_ root: TreeNode?) -> [Int] {
    //     guard let root = root else {
    //         return []
    //     }
    //     let left = preorderTraversal(root.left)
    //     let right = preorderTraversal(root.right)
    //     return [root.val] + left + right
    // }
}
