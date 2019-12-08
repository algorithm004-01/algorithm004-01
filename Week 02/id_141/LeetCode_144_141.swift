//
//  PreorderTraversal.swift
//  algorithm
//
//  Created by pingan on 2019/10/25.
//  Copyright © 2019 pingan. All rights reserved.
//

import Foundation

func preorderTraversal(_ root: TreeNode?) -> [Int] {
    var res: [Int] = [Int]();
    helper(root, &res);
    return res;
}

func helper(_ root: TreeNode?, _ res: inout [Int]) {
    if root != nil {
        res.append(root!.val);
        if root?.left != nil {
            helper(root?.left, &res);
        }
        if root?.right != nil {
            helper(root?.right, &res);
        }
    }
}
