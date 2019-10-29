class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null){
            return new ArrayList<>();
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> results = new ArrayList<>();
        
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < len; i++){
                Node parent = queue.poll();
                list.add(parent.val);
                
                for (Node node : parent.children) {
                    queue.add(node);
                }
            }
            results.add(list);
        }
        
        return results;
    }
}