//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树
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
public List<Integer> postorder(Node root) {
    List<Integer> list = new ArrayList<>();
    traversal(root, list);
    return list;
}
public void traversal(Node node, List<Integer> list){
    if (node != null) {
        for(Node child : node.children) {
            traversal(child, list);
        }
        list.add(node.val);
    }
}