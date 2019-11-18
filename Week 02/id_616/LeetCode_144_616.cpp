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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        preorderTraversalHelper(result, root);
        return result;
    }
    
    void preorderTraversalHelper(vector<int> &result, TreeNode* root){
        if(root == NULL) return;
        result.push_back(root->val);
        preorderTraversalHelper(result, root->left);
        preorderTraversalHelper(result, root->right);
        return;
    }    
};