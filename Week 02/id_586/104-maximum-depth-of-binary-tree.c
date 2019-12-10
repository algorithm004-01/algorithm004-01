/*
 * 给定一个二叉树，找出其最大深度
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数
 * 说明: 叶子节点是指没有子节点的节点。
 * */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

/*
 * 递归： DFS（深度优先搜索）策略
 * */
int maxDepth(struct TreeNode *root) {
    if (!root) return 0;

    int left_h = maxDepth(root->left);
    int right_h = maxDepth(root->right);

    return left_h > right_h? left_h + 1 : right_h + 1;
}