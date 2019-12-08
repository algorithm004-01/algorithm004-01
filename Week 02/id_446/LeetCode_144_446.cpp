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
        vector<int> nodes;
        recPreOrder(root, nodes);
        return nodes;
    }
private:
    
    void recPreOrder(TreeNode* root, vector<int> &nodes){
        if(root == NULL){
            return;
        }
        nodes.push_back(root->val);
        recPreOrder(root->left, nodes);
        recPreOrder(root->right, nodes);
    }
};