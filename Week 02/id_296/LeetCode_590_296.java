/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
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
    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> postorder(Node root) {
        helper(root);
        return res;
    }

    public void helper(Node root) {
        if (root == null) {
            return;
        }
        int s = root.children.size();
        for (int i = 0; i < s; i++) {
            helper(root.children.get(i));
        }
        res.add(root.val);
    }
}
// @lc code=end

