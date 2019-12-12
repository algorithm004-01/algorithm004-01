package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    public void traversal(TreeNode node, List<Integer> list){
        if (node != null) {
            list.add(node.val);
            traversal(node.left, list);
            traversal(node.right, list);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
