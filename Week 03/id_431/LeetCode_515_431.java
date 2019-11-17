package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/31
 */
public class FindLargestValueInEachTreeRow {

    /**
     * 广度优先搜索
     * @param root
     * @return
     */
//    public List<Integer> largestValues(TreeNode root) {
//        if (root == null) return Collections.emptyList();
//        Deque<TreeNode> deque = new LinkedList<>();
//        deque.addLast(root);
//        List<Integer> list = new ArrayList<>();
//        while (!deque.isEmpty()) {
//            int size = deque.size();
//            int max = Integer.MIN_VALUE;
//            while (size-- > 0) {
//                TreeNode node = deque.removeFirst();
//                max = Math.max(max, node.val);
//                if (node.left != null) deque.addLast(node.left);
//                if (node.right != null) deque.addLast(node.right);
//            }
//            list.add(max);
//        }
//        return list;
//    }

    /**
     * 深度优先搜索
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list, 1);
        return list;
    }

    /**
     * 深度优先遍历  DFS
     * @param node
     */
    public void traversal(TreeNode node, List<Integer> list, int deep){
        if (node == null) return;
        if (list.size() < deep) list.add(node.val);
        else list.set(deep - 1, Math.max(node.val, list.get(deep - 1)));
        traversal(node.left, list, deep + 1);
        traversal(node.right, list, deep + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
