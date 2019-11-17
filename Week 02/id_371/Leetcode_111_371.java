import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-05 06:18
 **/

public class Leetcode_111_371 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 防解1:DFS
     *
     * @author Shaobo.Qian
     * @date 2019/11/5
     */
    public int minDepth3(TreeNode root) {
        if (root == null) return 0;
        return recur3(root);
    }

    private int recur3(TreeNode root) {
        //1.递归出口,遇到叶子节点
        if (root.left == null && root.right == null) return 1;
        //2.1 处理当前层逻辑,如果左节点为空,去递归右节点
        if (root.left == null) {
            //3. 去下一层,每走一层,结果+1
            return recur3(root.right) + 1;
        }
        //2.2处理当前层逻辑,如果右节点为空,去递归左节点
        if (root.right == null) {
            return recur3(root.left) + 1;
        }
        //2.3处理当前层逻辑,如果左右节点都不为空,取较小值
        return Math.min(recur3(root.left), recur3(root.right)) + 1;
    }

    /**
     * 原解2:BFS
     *
     * @author Shaobo.Qian
     * @date 2019/11/5
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int step = 1;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    return step;
                }
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            step++;
        }
        return step;
    }

    /**
     * 原解1:DFS(未解出)--->反映出对 DFS 理解的不够
     *
     * @author Shaobo.Qian
     * @date 2019/11/5
     */
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        int step = 1;
        return recur(root, step);
    }

    private int recur(TreeNode root, int step) {
        //1.递归出口
        if (root.left == null && root.right == null) {
            return step;
        }
        //2.处理当前层

        if (root.left != null) {
            //3.去下一层
            recur(root.left, step + 1);
        }

        if (root.right != null) {
            recur(root.right, step + 1);
        }
        return step;
    }
}
