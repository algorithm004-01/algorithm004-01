package id_576;

import jdk.nashorn.api.tree.Tree;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_102_576 {

    //Approach 1: BFS, O(n)
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {//为什么直接写queue.size()会报错？
                // 因为queue.size()在循环体里值不会改变，需要借助变量cnt改变
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    //Approach 2: DFS, O(n)
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (res.size() == level) res.add(new LinkedList<>());
        res.get(level).add(root.val);
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }
}
