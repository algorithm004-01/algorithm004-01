import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-29 08:42
 **/

public class Leetcode_102_371 {

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 原解2:迭代,广度优先搜索
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue != null) {
            List<Integer> list = new ArrayList<>();
            int count = queue.size();
            while (count-- > 0) {//保证将当前层的元素在内循环中全部消耗掉
                //处理当前逻辑
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            result.add(list);
        }

        return result;
    }

    /**
     * 原解1:递归,广度优先搜索
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        recur(root, 0, result);
        return result;
    }

    private void recur(TreeNode root, int level, List<List<Integer>> result) {
        //1.递归出口
        if (root == null) return;

        //2.处理当前层
        if (level + 1 > result.size()) {//保证每一层的元素加入对应层的容器``
            result.add(new ArrayList<>());
        }
        List<Integer> list = result.get(level);
        list.add(root.val);
        //3.带上参数,去下一层
        if (root.left != null) recur(root.left, level + 1, result);
        if (root.right != null) recur(root.right, level + 1, result);
        //4.清理当前层
    }
}
