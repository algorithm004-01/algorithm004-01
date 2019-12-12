/**
 * NAryTreeLevelOrderTraversal
 */
public class NAryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) 
            return list;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()){
            List<Integer> curLevel = new ArrayList<>();
            int count = queue.size();
            for(int i = 0; i < count; i++){
                Node node = queue.poll();
                curLevel.add(node.val);
                for(Node n : node.children)
                    queue.add(n);
            }
            list.add(curLevel);
        }
        return list;
    }
}