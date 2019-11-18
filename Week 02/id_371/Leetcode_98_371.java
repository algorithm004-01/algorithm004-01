/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-27 09:00
 **/

public class Leetcode_98_371 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    /**
     * 仿解1:递归(这里的递归出口很巧妙,需要仔细体会)
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        return recur(root, null, null);
    }

    private boolean recur(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        //1.递归出口(这里注意四条 if 都是递归出口)
        //2.处理当前层
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        //3.带上参数去下一层
        if (!recur(root.left, lower, val)) return false;
        if (!recur(root.right, val, upper)) return false;
        return true;
    }


    /**
     * 原解1:递归(未解出)
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        int rootVal = root.val;
        return recur(root, rootVal) != null;
    }

    private TreeNode recur(TreeNode root, int rootVal) {
        //1.递归出口
        if (root != null && (root.left != null || root.right != null)) {
            //2.处理当前层
            if (root.left != null) {
                if (root.left.val >= root.val || root.left.val >= rootVal) {
                    return null;
                }
                //3.去下一层
                recur(root.left, rootVal);
            }
            if (root.right != null) {
                if (root.right.val <= root.val || root.right.val <= rootVal) {
                    return null;
                }
                recur(root.right, rootVal);
            }

        }
        return root;
    }
}
