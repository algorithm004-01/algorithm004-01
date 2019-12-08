/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
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

    public List<Integer> preorder(Node root) {
        helper(root);
        return res;
    }

    public void helper(Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        int s = root.children.size();
        for (int i = 0; i < s; i++) {
            helper(root.children.get(i));
        }
    }

}
// @lc code=end

