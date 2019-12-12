package simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class N_aryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    public void traversal(Node root, List<Integer> list){
        if (root != null) {
            list.add(root.val);
            for (Node node : root.children) {
                traversal(node, list);
            }
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
