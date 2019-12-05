package easy;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        TreeNode tmp = root;
        _invert(tmp);
        return tmp;
    }

    private void _invert(TreeNode node){
        if (node != null) {
            _invert(node.left);
            _invert(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
