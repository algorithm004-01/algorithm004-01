/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        } else {
            result.add(root.val);
            if(root.left != null){
                result.addAll(preorderTraversal(root.left));
            }
            if(root.right != null){
                result.addAll(preorderTraversal(root.right));
            }
            return result;
        }
    }
}
