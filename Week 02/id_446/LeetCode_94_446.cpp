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
        vector<int> nodes;
        recinorder(root,nodes);
        return nodes;
    }
    
private:
    void recinorder(TreeNode* root, vector<int> &nodes){
        //terminator
        if(root == NULL){
            return;
        }
        
        //process current logic and drill down
        recinorder(root->left,nodes);
        nodes.push_back(root->val);
        recinorder(root->right,nodes);        
    }
};