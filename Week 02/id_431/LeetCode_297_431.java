package hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/24
 */
public class SerializeAndDeserializeBinaryTree {
    private String non = "NULL"; //空节点字符串
    private String spliter = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder data = new StringBuilder();
        _serialize(root, data);
        return data.toString();
    }

    public void _serialize(TreeNode node, StringBuilder data){
        if (node == null){
            data.append(non);
            data.append(spliter);
        } else {
            data.append(node.val);
            data.append(spliter);
            _serialize(node.left, data);
            _serialize(node.right, data);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return _deserialize(queue);
    }

    public TreeNode _deserialize(Deque<String> queue){
        if (queue.size() == 0) return null;
        String val = queue.remove();
        if (non.equals(val)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = _deserialize(queue);
        node.right = _deserialize(queue);
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
