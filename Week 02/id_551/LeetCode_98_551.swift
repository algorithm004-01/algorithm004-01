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
    func isValidBST(_ root: TreeNode?) -> Bool {
       
        // recursion func
        func isValid(_ root: TreeNode?, lower: Int = Int.min, higher: Int = Int.max) -> Bool {
           
            // recursion terminator
            guard let r = root else { return true }
            
            // process current level
            if r.val <= lower || r.val >= higher { return false }
            
            // drill down (boundary convergence)
            if !isValid(r.left, lower: lower, higher: r.val) { return false }
            if !isValid(r.right, lower: r.val, higher: higher) { return false }
            
            return true
        }  
        
        return isValid(root)
    }
}



