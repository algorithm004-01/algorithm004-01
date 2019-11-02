/*
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 *     节点的左子树只包含小于当前节点的数。
 *     节点的右子树只包含大于当前节点的数。
 *     所有左子树和右子树自身必须也是二叉搜索树。
 **/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

/*
 * 递归： 在遍历树的时候要记录上下边界
 * 
 * */
bool helper(struct TreeNode *root, struct TreeNode *lower, struct TreeNode *upper) {
    if (!root) return true;  /* 遍历到最后一个返回 true */

    int val = root->val;

    if (!lower && val <= lower->val) return false;  /* 检查右子树最小边界是否合法 */
    if (!upper && val >= upper->val) return false;  /* 检查左子树最大边界是否合法 */

    /* 递归到下一级：对于右子树设置 root 为其最小边界 */
    if (!helper(root->right, root, upper)) return false;
    if (!helper(root->left, lower, root)) return false;

    return true;
}

bool isValidBST(struct TreeNode* root) {
    return helper(root, NULL, NULL);
}

/* 方法2 ：使用中序遍历查看是否有乱序的现象
 *  中序遍历后是一个排序好的数列
 *  */