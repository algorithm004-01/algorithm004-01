import java.util.*;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-29 21:47
 **/

public class Leetcode_515_371 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {

            this.val = val;
        }

    }

    /**
     * 原解2:优化 BFS
     * @param root
     * @return
     */
    public List<Integer> largestValues2(TreeNode root) {
        //边界条件
        if (root == null) return new ArrayList<>();
        //1.结果
        List<Integer> result = new ArrayList<>();
        //2.创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            Integer max = null;
            while (count-- > 0) {
                TreeNode curr = queue.poll();
                if (max == null
                ) {
                    max = curr.val;
                } else {
                    max = Math.max(max, curr.val);
                }
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            result.add(max);
        }
        return result;
    }

    /**
     * 原解1:BFS
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues1(TreeNode root) {
        //边界条件
        if (root == null) return new ArrayList<>();
        //1.结果
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        //2.创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //3.BFS
        while (!queue.isEmpty()) {
            Integer max = null;
            //3.1确定队列的广度
            int count = queue.size();
            while (count-- > 0) {
                TreeNode curr = queue.poll();
                if (!visited.contains(curr)) {
                    visited.add(curr);
                    //更新最大值
                    if (max == null) {
                        max = curr.val;
                    } else {
                        max = Math.max(curr.val, max);
                    }
                    max = Math.max(max, curr.val);
                    if (curr.left != null) queue.add(curr.left);
                    if (curr.right != null) queue.add(curr.right);
                }
            }
            result.add(max);
        }

        return result;
    }
}
