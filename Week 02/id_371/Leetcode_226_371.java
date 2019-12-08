/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-27 08:26
 **/

public class Leetcode_226_371 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 原解1:递归
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        //0.边界条件
        if (root == null) {
            return null;
        }
        //1.递归出口
        if (root.left != null || root.right != null) {
            //2.处理当前层
            if (root.left == null) {
                root.left = root.right;
                root.right = null;
                //3.带上参数,去下一层
                invertTree(root.left);
            } else if (root.right == null) {
                root.right = root.left;
                root.left = null;
                //3.带上参数,去下一层
                invertTree(root.right);
            } else {
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = temp;
                //3.带上参数,去下一层
                invertTree(root.left);
                invertTree(root.right);
            }
        }
        //4.清理当前层
        return root;
    }

}
