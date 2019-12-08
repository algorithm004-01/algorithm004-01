import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NTreePreTraversal {

    public List<Integer> preorder(Node root) {
        ArrayList<Integer> result = new ArrayList();
        LinkedList<Node> stack = new LinkedList();
        if (root == null){
            return  result;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            Node current  = stack.pop();
            result.add(current.val);
            if (current.children != null) {
                for (int i = current.children.size() - 1; i >= 0; i--){
                    stack.push(current.children.get(i));
                }
            }
        }

        return result;
    }

    public List<Integer> preorder2(Node root) {
        ArrayList<Integer> result = new ArrayList();
        LinkedList<Node> stack = new LinkedList();
        if (root == null){
            return  result;
        }

        result.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            List<Integer> childResult = preorder(root.children.get(i));
            result.addAll(childResult);
        }
        return result;
    }
}
