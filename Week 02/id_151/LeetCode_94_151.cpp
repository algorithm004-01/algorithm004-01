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
        if (root == NULL) {
            return {};
        }
        
        vector<int> ret;
        stack<TreeNode*> s;
        
        while (! s.empty()) {
            root = s.top();
            
            s.pop();
            
            if (root->left)
                s.push(root->left);
        }
    }
};
