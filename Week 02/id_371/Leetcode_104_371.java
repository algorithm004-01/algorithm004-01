/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-27 20:56
 **/

public class Leetcode_104_371 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 仿解1:递归
     */
    public int maxDepth1(TreeNode root) {
        //1.递归出口(递归到不能递归的时候,往上一层栈返回数据)
        if (root == null) {
            return 0;
        } else {
            //3.往下一层
            int leftMax = maxDepth1(root.left);
            int rightMax = maxDepth1(root.right);
            //2.处理当前层
            return Math.max(leftMax, rightMax) + 1;
            //4.清理当前层
        }
    }

    /**
     * 原解1:递归(未解出-->对递归理解不透彻)
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return recur(root, 0);
    }
    /**
     * 原解1:(未解出-->对递归理解不透彻)
     * @param root
     * @param depth
     * @return
     */
    private int recur(TreeNode root, int depth) {

        //1.递归出口
        if (root != null) {
            //2.处理当前层
            //3.带上参数,向下一层
            if (root.left != null) {
                int leftDepth = recur(root.left, depth + 1);
                depth = Math.max(depth, leftDepth);
            }
            //3.带上参数,向下一层
            if (root.right != null) {
                int rightDepth = recur(root.right, depth + 1);
                depth = Math.max(depth, rightDepth);
            }
        }
        //4.清理当前层
        return depth;
    }

}
