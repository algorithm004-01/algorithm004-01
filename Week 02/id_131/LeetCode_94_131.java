package com.lzhlyle.leetcode.self.no94;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        // base condition
        if (root == null) return Collections.emptyList();
        if (root.left == null && root.right == null) return Collections.singletonList(root.val);

        // recursion
        List<Integer> res = new ArrayList<>();
        this._inorder(root, res);
        return res;
    }

    private void _inorder(TreeNode root, List<Integer> res) {
        // terminator
        if (root == null) return;

        // process
        // drill down
        this._inorder(root.left, res);
        res.add(root.val);
        this._inorder(root.right, res);

        // reverse
    }
}
