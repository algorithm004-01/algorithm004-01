import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new LinkedList();
        }

        LinkedList<Node> currentStack = new LinkedList();
        LinkedList<Node> nextStack = new LinkedList();
        List<List<Integer>> result = new LinkedList();
        currentStack.add(root);
        while (!currentStack.isEmpty()) {
            // 遍历当前层
            LinkedList<Integer> tempResult = new LinkedList();
            while (!currentStack.isEmpty()) {
                // 把当前层的子节点添加到下一层。
                Node node = currentStack.pop();
                tempResult.add(node.val);
                List<Node> children = node.children;
                Collections.reverse(children);
                nextStack.addAll(children);
            }
            // 当前层遍历完成时，把下一层的数据赋给当前层。下一层请空。
            result.add(tempResult);
            currentStack.addAll(nextStack);
            nextStack.clear();
        }
        return  result;
    }
}
