package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    public void traversal(TreeNode node, List<Integer> list){
        if (node != null) {
            traversal(node.left, list);
            list.add(node.val);
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
