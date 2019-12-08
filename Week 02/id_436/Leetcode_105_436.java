/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Leetcode_105_436 {
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0 , inorder.length - 1);
    }
    public TreeNode buildTree(int[] preorder, int idx, int[] inorder, int start, int end){
        if(idx > preorder.length || start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx]);
        int i = end;// as index
        while(i >= start){
            if(preorder[idx] == inorder[i]) break;
            i--;
        }
        root.left = buildTree(preorder, idx + 1, inorder, start, i - 1);
        root.right = buildTree(preorder, idx + i - start + 1, inorder, i + 1, end);
        return root;
    }
}