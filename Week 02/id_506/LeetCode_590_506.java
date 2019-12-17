class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        
        process(root, list);
        
        return list;
        
    }
    
    public void process(Node root, List<Integer> list){
        
        if (root == null){
            return;
        }
        
        for (Node node : root.children){
            
            process(node, list);
            
        }
        
        list.add(root.val);
        
    }
    
}