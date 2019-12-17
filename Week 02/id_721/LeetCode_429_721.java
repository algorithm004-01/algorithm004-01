package tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author alis
 * @date 2019/10/27 9:09 AM
 * 题目理解：
 * 将一个二叉树的所有结点，从上往下，输出，
 * 输出的规则是，逐层输出，输出每一层的时候，该层的结点，从左往右一起输出到该层的集合中
 * --> 前序遍历类似
 */
public class LeetCode_429_721 {

    /**
     * 递归实现
     * 核心思想：每次递归以层为基本单位，需要从根结点开始就将每一层的所有节点找齐，
     * 在每一层处理的时候，利用哈希表/数组将每一层的结点都遍历出来，这个遍历结果就是输出的时候本层次的数据
     */
    public List<List<Integer>> levelOrderRecur(NTreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        /* Map<Integer, List<Integer>> resultMap = new HashMap<>();*/
        List<List<Integer>> result = new ArrayList<>();
        _generateLevelOrder(0, Arrays.asList(root), result);
        return result;
    }

    private void _generateLevelOrder(int level, List<NTreeNode> roots, List<List<Integer>> result) {
        if (roots == null || roots.isEmpty()) return;
        // process 将本根层的所有子结点遍历出来
        List<NTreeNode> childRoots = new ArrayList<>();
        roots.stream().forEach(root -> {
            if (root.children != null && !root.children.isEmpty()) {
                childRoots.addAll(root.children);
            }
        });
        result.add(roots.stream().map(value -> value.val).collect(Collectors.toList()));
        _generateLevelOrder(level + 1, childRoots, result);
    }

    /**
     * 队列实现分层迭代
     * 其实现方法与利用栈来辅助循环的方式类型，
     * 不过队列实现的核心点在于每一层遍历开始处理之前，先将本层的待处理结点数记录，每处理一个结点，减少一个待处理计数
     * 因为在本层处理的过程中，需要将结点的子结点入队，用于下一层处理
     * 这样就可以在每一层遍历输出的时候，同时将下一层的所有结点都找到，存入队列
     * 待本层待处理结点处理完毕，进入下一层处理下一层待处理的结点
     * 如此迭代
     */
    public List<List<Integer>> levelOrderQueue(NTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<NTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> currentLayer = new ArrayList<>();
            while (count-- > 0) {
                NTreeNode node = queue.poll();
                currentLayer.add(node.val);
                if (null != node.children && !node.children.isEmpty()) {
                    for (NTreeNode child : node.children) {
                        queue.add(child);
                    }
                }
            }
            result.add(currentLayer);
        }
        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
