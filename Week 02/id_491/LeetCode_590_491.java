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
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        } else {
            if(root.children != null && !root.children.isEmpty()){
                for(int i =0; i < root.children.size(); i++){
                     result.addAll(postorder(root.children.get(i)));
                }
            }
            result.add(root.val);
            return result;
        }
    }
}
