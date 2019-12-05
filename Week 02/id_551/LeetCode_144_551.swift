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
    func preorderTraversal(_ root: TreeNode?) -> [Int] {
        // recursion terminator
        guard root != nil else { return [] }
        // process current level
        return [root!.val] + preorderTraversal(root!.left) + preorderTraversal(root!.right)
    }
}
