package week02;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_590_696 {

    private List<Integer> list = new LinkedList<>();

    public List<Integer> postorder(Node root) {
        if (root != null) {
            for (Node node : root.children) {
                postorder(node);
            }
            list.add(root.val);
        }
        return list;
    }
}
