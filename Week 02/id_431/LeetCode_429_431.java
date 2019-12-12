package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class N_aryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root != null){
            list.add(Arrays.asList(root.val));
            traversal(root.children, list);
        }
        return list;
    }

    public void traversal(List<Node> nodes, List<List<Integer>> list){
        if (nodes.size() > 0) {
            List<Integer> vals = new ArrayList<>(nodes.size());
            List<Node> children = new ArrayList<>();
            for (Node node : nodes) {
                vals.add(node.val);
                if (node.children != null) {
                    children.addAll(node.children);
                }
            }
            list.add(vals);
            traversal(children, list);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
