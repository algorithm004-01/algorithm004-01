class Node{
    public int val;
    public List<Node> children;
    public Node() {};
    
    public Node( int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
    
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<Integer>() ;
        helper(root ,res) 
        return res;
    }
    
    public void helper(Node root, List<Integer> res){
        if (root == null) return ;
        
        for(Node node : root.children){
            helper(root, res);
        }
        
        res.add(root.val);
    }
}

//方法2 
public List<Integer> postorder(Node root){
    List<Integer> list = new ArrayList<>();
    
    if( root == null) return list;
    
    Stack<Node> stack = new Stack<>();
    stack.add(root);
    
    while(!stack.isEmpty()) {
        root = stack.pop();
        list.add(root.val);
        for( Node node: root.children){
            stack.add(node);
        }
    }
    //先取的右节点
    Collections.reverse(list);
    return list;
} 