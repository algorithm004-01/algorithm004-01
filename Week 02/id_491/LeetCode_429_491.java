/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Node> levelNodeList = new ArrayList<>();
            List<Integer> currentLevel = new ArrayList<>();
            while (!queue.isEmpty()) {
                Node temp = queue.poll();
                if (temp != null) {
                    currentLevel.add(temp.val);
                    if (temp.children != null && !temp.children.isEmpty()) {
                        levelNodeList.addAll(temp.children);
                    }
                }
            }
            result.add(currentLevel);
            if (!levelNodeList.isEmpty()) {
                queue.addAll(levelNodeList);
            }
        }
        return result;
    }
}
