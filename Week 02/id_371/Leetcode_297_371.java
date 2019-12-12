import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-05 06:18
 **/

public class Leetcode_297_371 {

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 仿解1:DFS
     *
     * @author Shaobo.Qian
     * @date 2019/11/5
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return buildString(root, sb).toString();
    }

    private StringBuilder buildString(TreeNode root, StringBuilder sb) {
        //1.递归出口
        if (root == null) {
            return sb.append("null,");
        } else {
            //2.处理当前层逻辑,拼接当前层当前节点的 val
            sb.append(root.val).append(",");
            //3.1去下一层,拼接左节点
            sb = buildString(root.left, sb);
            //3.2去下一层,拼接右节点
            sb = buildString(root.right, sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if ("null".equals(val)) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);
            return root;
        }
    }
}
