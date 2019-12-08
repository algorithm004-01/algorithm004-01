package com.leetcode.week02;

import com.leetcode.week02.util.TreeNode;
/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_236_416 {
    private TreeNode treeNode;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        circleTreeNode(root,p,q);
        return treeNode;
    }
    public boolean circleTreeNode(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (null == currentNode) {
            return false;
        }
        //左边是否有当前传入的p或者q
        int left = circleTreeNode(currentNode.left, p, q) ? 1 : 0;
        //右边是否有当前传入的p或者q
        int right = circleTreeNode(currentNode.right, p, q) ? 1 : 0;
        int mid = ((currentNode == p) || (currentNode == q)) ? 1 : 0;
        if (left + right + mid >= 2) {//说明了当前节点下面，可以同时查找到左节点和右节点是给定的参数值
            this.treeNode = currentNode;
        }
        return left + right + mid > 0;
    }
}
