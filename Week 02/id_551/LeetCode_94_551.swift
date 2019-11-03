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
    func inorderTraversal(_ root: TreeNode?) -> [Int] {
        // Recursion terminator
        guard root != nil else { return [] }
        // Process current level and Drill down
        return inorderTraversal(root!.left) + [root!.val] + inorderTraversal(root!.right)  
    }
}
