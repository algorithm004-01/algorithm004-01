package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class N_aryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> array = new ArrayList<>();
        traversal(root, array);
        return array;
    }

    public void traversal(Node node, List<Integer> list){
        if (node != null) {
            if (node.children != null) {
                for (Node child : node.children) {
                    traversal(child, list);
                }
            }
            list.add(node.val);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            this.val = _val;
            this.children = _children;
        }
    }
}
