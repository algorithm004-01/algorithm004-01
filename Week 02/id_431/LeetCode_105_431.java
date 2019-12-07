package medium;

/**
 * @author 潘磊明
 * @date 2019/10/25
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return _buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode _buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
        if (preStart >= preorder.length || inStart > inEnd) return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int mid = 0;
        for (int i = inStart; i < inEnd + 1; i++) {
            if (inorder[i] == preorder[preStart]) {
                mid = i;
            }
        }
        node.left = _buildTree(preorder, inorder, preStart + 1, inStart, mid - 1);
        node.right = _buildTree(preorder, inorder, preStart + 1 + mid - inStart, mid + 1, inEnd);
        return node;
    }

     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
}
