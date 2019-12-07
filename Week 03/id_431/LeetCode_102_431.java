package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/31
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 使用队列先进先出进行层次遍历
     * @param root
     * @return
     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (root == null) return result;
//        Deque<TreeNode> deque = new LinkedList<>();
//        deque.addLast(root);
//        while (!deque.isEmpty()) {
//            List<Integer> list = new ArrayList<>(deque.size());
//            int count = deque.size();
//            while (count-- > 0) {
//                TreeNode node = deque.removeFirst();
//                list.add(node.val);
//                if (node.left != null) deque.addLast(node.left);
//                if (node.right != null) deque.addLast(node.right);
//            }
//            result.add(list);
//        }
//        return result;
//    }

    /**
     * 使用先序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traversal(result, root, 0);
        return result;
    }

    private void traversal(List<List<Integer>> result, TreeNode node, int deep) {
        if (node == null) return;
        if (result.size() < deep + 1) {
            result.add(new ArrayList<>());
        }
        result.get(deep).add(node.val);
        traversal(result, node.left, deep + 1);
        traversal(result, node.right, deep + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
