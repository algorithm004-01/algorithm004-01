/**
 * ConstructBinaryTreeFromPreorderAndInorderTraversal
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return _buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode _buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight){
        if(preLeft > preRight && inLeft > inRight) return null;
        
        int rootValue = preorder[preLeft];
        int rootIndex = inLeft;
        while(rootValue != inorder[rootIndex]) rootIndex++;
        int leftNodeCount = rootIndex - inLeft;
        
        TreeNode leftNode = _buildTree(preorder, preLeft + 1, preLeft + leftNodeCount, inorder, inLeft, rootIndex - 1);
        TreeNode rightNode = _buildTree(preorder, preLeft + leftNodeCount + 1, preRight, inorder, rootIndex + 1, inRight);
        
        TreeNode root = new TreeNode(rootValue);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}