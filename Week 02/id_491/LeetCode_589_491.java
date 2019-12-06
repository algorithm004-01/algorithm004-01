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
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        } else {
            result.add(root.val);
            if(root.children != null && !root.children.isEmpty()){
                for(int i =0; i < root.children.size(); i++){
                     result.addAll(preorder(root.children.get(i)));
                }
            }
            
            return result;
        }
    }
}
