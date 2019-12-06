/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

/*
 * 方法 1 ：递归
 *  1. 空树无需翻转
 *  2. 翻转树就是把树的左右子树互换     
 * */
struct TreeNode* invertTree(struct TreeNode* root){
    if (!root) return root;

#if 1
    struct TreeNode *tmp = root->left;
    root->left = root->right;
    root->right = tmp;
    
    if (root->left != NULL) invertTree(root->left);
    if (root->right != NULL) invertTree(root->right);
#else
    struct TreeNode *right = invertTree(root->right);
    struct TreeNode *left = invertTree(root->left);

    root->left = right;
    root->right = left;
#endif

    return root;
}
