package com.lqw.algorithm.recursion;


/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * 图：见resources中binarytree
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 *
 * 解题思路
 * 1、递归
 * @see SolutionThree
 */
public class SolutionTwo {

    private TreeNode recentCommonAncestor = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return recentCommonAncestor;
    }

    private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        //terminator终止条件
        if (root == null || recentCommonAncestor != null) {
            return false;
        }

        //drill down
        //从左子树找
        int left = recurseTree(root.left, p, q) ? 1 : 0;
        //从右子树找
        int right = recurseTree(root.right, p, q) ? 1 : 0;


        //process处理当前逻辑
        int mid = root == p || root == q ? 1 : 0;

        if (right + left + mid == 2) {
            recentCommonAncestor = root;
        }
        return right + left + mid > 0;
        //restore current status 清理当前层
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
