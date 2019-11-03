package week02;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_94_696 {

    private List<Integer> list = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
}
