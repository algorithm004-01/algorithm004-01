/*
 * 给定一个二叉树，找出其最小深度
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量
 * 
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


#define min(l, r) (l < r ? l : r)
#define max(l, r) (l > r ? l : r)

int minDepth(struct TreeNode* root){
    if (!root) return 0;

    int l = minDepth(root->left);
    int r = minDepth(root->right);

    return 1 + (min(l, r) ? min(l, r) : max(l, r));
}

int minDepth(struct TreeNode* root){
    if (!root) return 0;

    int l = minDepth(root->left);
    int r = minDepth(root->right);

    if (l == 0 || r == 0) return 1 + l + r;
    
    return 1 + min(l, r);

    if(root==NULL)return 0;//树为空
    if(root->left==NULL && root->right==NULL)return 1;//无左右子树
        
    if(root->left==NULL) return run(root->right)+1; //无左子树，以右子树为根，看它的左右子树
        
    if(root->right==NULL)return run(root->left)+1;//同上
        
    return 1+min(run(root->left),run(root->right));
}
