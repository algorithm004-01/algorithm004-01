import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_94_716 {
    public List<TreeNode> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (res != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}