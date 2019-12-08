//
//  InorderTraversal.swift
//  algorithm
//
//  Created by pingan on 2019/10/24.
//  Copyright © 2019 pingan. All rights reserved.
//

import Foundation

class InorderTraversal {
    func inorderTraversal(_ root: TreeNode?) -> [Int] {
        var res: [Int] = [Int]();
        helper(root, &res);
        return res;
    }
    func helper(_ root: TreeNode?, _ res: inout [Int]) {
        if root != nil {
            if root?.left != nil {
                helper(root?.left, &res);
            }
            res.append(root!.val);
            if root?.right != nil {
                helper(root?.right, &res);
            }
        }
    }
//    func inorderTraversal(_ root: TreeNode?) -> [Int] {
//        var res: [Int] = [Int]();
//        let stack: Stack<TreeNode> = Stack();
//        var curr = root;
//        while curr != nil || !stack.isEmpty()  {
//            while curr != nil {
//                stack.push(curr!);
//                curr = curr?.left;
//            }
//            curr = stack.pop();
//            res.append(curr!.val);
//            curr = curr?.right;
//        }
//        return res;
//    }
}
