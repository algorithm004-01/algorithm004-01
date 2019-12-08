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

//基于栈的遍历
class Solution {
    func inorderTraversal(_ root: TreeNode?) -> [Int] {
        var stack = [TreeNode]()
        var currentNode = root;
        var result = [Int]()
        
        while currentNode != nil || stack.count != 0 {
            //左节点入栈
            while currentNode != nil {
                stack.append(currentNode!)
                currentNode = currentNode!.left
            }
            //出栈并把右节点入栈
            currentNode = stack.last
            stack.removeLast();
            result.append(currentNode!.val)
            currentNode = currentNode?.right
        }
        return result
    }
}

//递归 时间复杂度O(n)
class Solution {
    func inorderTraversal(_ root: TreeNode?) -> [Int] {
        guard let root = root else {
            return []
        }
        let left = inorderTraversal(root.left)
        let right = inorderTraversal(root.right)
        return left + [root.val] + right
    }
}
