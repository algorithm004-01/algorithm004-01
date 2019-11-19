import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-05 08:29
 **/

public class Leetcode_236_371 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    /**
     * 仿解1:(分治)
     * @author Shaobo.Qian
     * @date 2019/11/5
     * @link https://www.youtube.com/watch?v=13m9ZCB8gjw
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //1.1递归出口
        if(root == null) return null;
        //1.2递归出口 当前节点即要找的节点,找到了节点,直接返回
        if(root == p || root == q) return root;
        //2.分治,化成子问题处理
        TreeNode leftNode = lowestCommonAncestor1(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor1(root.right, p, q);
        //3.对子问题返回的结果综合处理
        //3.1子问题结果都不为 null
        if(leftNode !=null && rightNode!=null) return root;
        //3.2子问题结果都为 null
        if(leftNode == null && rightNode == null) return null;
        //3.1子问题结果一个 null,一个不为 null
        return leftNode != null ? leftNode:rightNode;
    }



    /**
     * 原解1:(分治)-->未解除(对递归理解不深入,可以画递归图帮助理解)
     *
     * @author Shaobo.Qian
     * @date 2019/11/5
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        recur(root, p, q,queue);
        return queue.poll();
    }

    private void recur(TreeNode node, TreeNode p, TreeNode q, Queue<TreeNode> queue) {
        if (isAncestor(node, p) && isAncestor(node, q)) {
            queue.add( node);
        }
        if (node.left != null) recur(node.left, p, q,queue);
        if (node.right != null) recur(node.right, p, q,queue);

    }

    /**
     * 判断一个节点是否是另外一个节点的祖先
     *
     * @author Shaobo.Qian
     * @date 2019/11/5
     */
    public boolean isAncestor(TreeNode p, TreeNode q) {
        if (p == q) return true;
        if (p.left != null) isAncestor(p.left, q);
        if (p.right != null) isAncestor(p.right, q);
        return false;
    }
}
