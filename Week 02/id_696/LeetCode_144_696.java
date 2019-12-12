package week02;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_144_696 {

    private List<Integer> list = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }
}
