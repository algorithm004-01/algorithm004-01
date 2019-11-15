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
    func maxDepth(_ root: TreeNode?) -> Int {
        guard let r = root else { return 0 }
        // handle exponentially more recursive call to null root nodes
        let l_h = (r.left == nil) ? 0 : maxDepth(r.left)
        let r_h = (r.right == nil) ? 0 : maxDepth(r.right)
        return (l_h > r_h ? l_h : r_h) + 1
    }
}
