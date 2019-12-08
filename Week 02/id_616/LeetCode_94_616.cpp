/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        if(root == NULL) return result;
        inorderTraversalHelper(root,result);
        return result;
    }

    void inorderTraversalHelper(TreeNode* root, vector<int> &res) {
        if(root->left != NULL) inorderTraversalHelper(root->left, res);
        res.push_back(root->val);
        if(root->right != NULL) inorderTraversalHelper(root->right,res);
    }
};