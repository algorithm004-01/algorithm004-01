//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        if (preorder.length == 0) {
            return null;
        }
        int index = 0;
        while (inorder[index] != preorder[0]) {
            index++;
        }
        TreeNode gen = new TreeNode(preorder[0]);
        int[] leftPre = new int[index];
        int[] leftIn = new int[index];
        for (int i = 0; i < index; i++) {
            leftIn[i] = inorder[i];
            leftPre[i] = preorder[i + 1];
        }
        int[] rightPre = new int[preorder.length - index - 1];
        int[] rightIn = new int[preorder.length - index - 1];
        for (int i = 0; i < rightPre.length; i++) {
            rightPre[i] = preorder[index + 1 + i];
            rightIn[i] = inorder[index + 1 + i];
        }
        gen.left = buildTree(leftPre, leftIn);
        gen.right = buildTree(rightPre, rightIn);
        return gen;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
