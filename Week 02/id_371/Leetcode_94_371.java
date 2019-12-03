import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-24 14:55
 **/

public class Leetcode_94_371 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //3.清理当前层
        return recur(root, result);
    }

    public List<Integer> recur(TreeNode root, List<Integer> result) {
        //1.递归出口
        if (root != null) {
            //2.处理当前层
            if (root.left != null) {
                //3.向下一层
                recur(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                recur(root.right, result);
            }
        }
        //4.清理当前层
        return result;
    }

}
