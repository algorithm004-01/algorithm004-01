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
    func minDepth(_ root: TreeNode?) -> Int {
        guard let r = root else { return 0 }
        
        let left_h = minDepth(r.left)
        let right_h = minDepth(r.right)
        
        if r.left == nil || r.right == nil {
            // leaf node、left null right node、right null left node
            // 0 0, 0 r_h, l_h 0
            return left_h + right_h + 1
        } else {
            return (left_h > right_h ? right_h : left_h) + 1
        }
    }
}
