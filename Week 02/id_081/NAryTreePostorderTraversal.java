/**
 * NAryTreePostorderTraversal
 */
public class NAryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        realWork(root, list);
        return list;
    }
    
    public void realWork(Node root, List<Integer> list){
        if (root == null)
            return  ;
        for(Node node : root.children)
            realWork(node, list);
        list.add(root.val);
    }
}