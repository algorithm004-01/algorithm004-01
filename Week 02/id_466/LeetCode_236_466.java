//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
//
//
//
//
//
// 示例 1:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//
//
// 示例 2:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//
//
//
//
// 说明:
//
//
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉树中。
//
// Related Topics 树
package com.aseara.leetcode.editor.cn.a236;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 236.二叉树的最近公共祖先 <br />
 * Date: 2019/10/27 <br/>
 *
 * @author qiujingde
 */
class LowestCommonAncestorOfABinaryTree {
    private Solution solution = new Solution();

    @Test
    void test1() {
        TreeNode root = new TreeNode(3);
        TreeNode expected = root;

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        TreeNode node = root.left;
        node.left = new TreeNode(6);
        node.right = new TreeNode(2);

        node = node.right;
        node.left = new TreeNode(7);
        node.right = new TreeNode(4);

        node = root.right;
        node.left = new TreeNode(0);
        node.right = new TreeNode(8);


        assertEquals(expected.val,
                solution.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);

        expected = new TreeNode(5);
        assertEquals(expected.val,
                solution.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4)).val);
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return path1(root, p, q);
    }

    private TreeNode path1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lower = root;

        int containsSize = 2;
        while (containsSize != 1) {
            if (lower.val == p.val || lower.val == q.val) {
                return lower;
            }
            containsSize = getContainSize(lower.left, p.val, q.val);
            if (containsSize == 0) {
                lower = lower.right;
            } else if (containsSize == 2) {
                lower = lower.left;
            }
        }

        return lower;
    }

    private int getContainSize(TreeNode root, int p, int q) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int size = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == p || node.val == q) {
                size ++;
                if (size == 2) {
                    return size;
                }
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return size;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
