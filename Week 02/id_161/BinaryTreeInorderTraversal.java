//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    traversal(root, list);
    return list;
}

public void traversal(TreeNode node, List<Integer> list) {
    if (node != null) {
        if (node.left != null)
            traversal(node.left, list);
        list.add(node.val);
        if (node.right != null)
            traversal(node.right, list);
    }
}