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

package leetcode.editor.cn;

import java.util.*;

//Java：N叉树的后序遍历
public class P590NAryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P590NAryTreePostorderTraversal().new Solution();
        // TO TEST

    }
    

//leetcode submit region begin(Prohibit modification and deletion)

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

    //{"$id":"1",
    // "children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},
    // {"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}
//后序遍历
class Solution {
        //递归
//    public List<Integer> postorder(Node root) {
//
//        List<Integer> result = new ArrayList<Integer>();
//        if (root == null) return result;
//        List<Node> childrenList = root.children;
//        if (childrenList != null){
//            searchAndPut(root,result);
//        }
//        return result;
//    }
//
//
//    private void searchAndPut(Node root,  List<Integer> result ){
//        if (root == null) return ;
//        if (root.children == null) return;
//        for (Node node : root.children) {  //栈的深入
//            searchAndPut(node,result);
//        }
//        result.add(root.val); //出栈
//    }

        //迭代
//public List<Integer> postorder(Node root) {
//
//    List<Integer> ans = new LinkedList<>();
//    Stack<Node> s1 = new Stack<>();
//    Stack<Integer> s2 = new Stack<>(); //用一个辅助栈记录当前节点已经访问到其第几个孩子了
//    Node node = root;
//    while (node != null || !s1.isEmpty()) {
//        while (node != null) {
//            s1.push(node);  //s1放了整棵树
//            s2.push(1); //s2存放访问记录。当前节点第一个孩子（内层循环遍历完成，s2存放所有左子树）
//            if (node.children != null && node.children.size() > 0) { //判断当前节点存在孩子节点
//                node = node.children.get(0); //将左子树赋给当前节点。
//            } else { //否则，跳出内层循环。（左子树到底）
//                node = null;
//            }
//        }
//        node = s1.peek(); //取出第栈顶第一个节点。 s2.peek() 该节点在其树中的位置
//        //如果已经访问到最后一个孩子了，那么就该访问当前节点了。
//        if (node.children == null || s2.peek() >= node.children.size()) { //当前节点（左子树节点）无叶子节点，或者  s2.peek() >= node.children.size() 判断是否存在右子节点。
//            ans.add(node.val); //当前node满足条件，加到结果。 满足条件--左右中，
//            s1.pop();
//            s2.pop();
//            node = null;
//        } else { //否则继续遍历
//            node = node.children.get(s2.peek()); //
//            s2.push(s2.pop() + 1);
//        }
//    }
//
//    //难点： 怎么判断是右子树
//    return ans;
//}
//      https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/submissions/
        //更为简洁的写法。这种解法的思想是先序遍历的变形，先序遍历是“根->左->右”，后序遍历是“左->右->根”，那么把先序遍历改成“根->右->左”，再逆序一下就是后序遍历。
        //逆序一下，改造后的先序遍历
        public List<Integer> postorder(Node root) {
            List<Integer> ans = new LinkedList<>(); //
            if (root == null) return ans;
            Stack<Node> stack = new Stack(); //stack：右比左先出 ans：右比左先插（头插法）-> 左在右前门
            stack.push(root);
            while (!stack.empty()){
                root = stack.pop();
                ans.add(0,root.val); //头插
                if (root.children !=null){
                    for (Node child : root.children) {
                        stack.push(child); //左右进，左右出
                    }
                }
            }
            return ans;
        }



}

}