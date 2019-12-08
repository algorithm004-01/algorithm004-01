package week02;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_589_696 {

    private List<Integer> list = new LinkedList<>();

    public List<Integer> preorder(Node root) {
        if (root != null) {
            list.add(root.val);
            for (Node node : root.children) {
                preorder(node);
            }
        }
        return list;
    }
}
