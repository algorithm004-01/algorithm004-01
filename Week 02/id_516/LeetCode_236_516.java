package com.hjj.leetcode.oct27;

import java.util.*;
// 递归的时间复杂度 基本都是k^n
public class LeetCode236 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 别人的优秀题解 最后三行是主要思路
     * 1.从左树和右树中去寻找，若左右子树都找不到那么就返回空
     * 2. 左子树和右子树分别找到了那么根节点是最低父节点
     * 3. 如果一边为空 那么另一个就为最低父节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        // terminated
        if (root == null || root == p || root == q) return root;
        // drill down
        TreeNode left = lowestCommonAncestor3(root.left, p, q);
        TreeNode right = lowestCommonAncestor3(root.right, p, q);

//        return left == null ? right : right == null ? left : root;

        if(left == null && right == null) return null;
        else if(left != null && right != null) return root;
        else return left == null ? right : left;
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // find p and q and store their parents (store all loop parent son )
        Map<TreeNode,TreeNode> parents = new HashMap<>();
        // use stack to loop the tree
        Deque<TreeNode> stack = new ArrayDeque<>();
        parents.put(root,null);
        stack.push(root);
        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parents.put(node.left,node);
                stack.push(node.left);
            }

            if (node.right != null) {
                parents.put(node.right,node);
                stack.push(node.right);
            }
        }
        // store pParents container
        Set<TreeNode> pParents = new HashSet<>();
        // store pParents
        while (p != null) {
            pParents.add(p);
            p = parents.get(p);
        }
        // find same parent
        while (!pParents.contains(q)) {
            q = parents.get(q);
        }

        return q;
    }


    private TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recur(root,p,q);
        return this.res;
    }

    private boolean recur(TreeNode root, TreeNode p, TreeNode q) {
        // terminated
        if (root == null) {
            return false;
        }
        // process & drill down
        int left =  recur(root.left,p,q) ? 1: 0;
        int right = recur(root.right,p,q) ? 1 : 0;
        int mid = (p == root || q == root) ? 1 : 0;

        if (left + right + mid >= 2) {
            this.res = root;
        }
        return (left + right + mid > 0);
    }


}
