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
    TreeNode* buildTree(vector<int> preorder, vector<int> inorder) {
        if (preorder.empty() || inorder.empty()) {
            return nullptr;
        }
        int j = -1;
        while(preorder[0] != inorder[++j]);
        TreeNode* newNode = new TreeNode(preorder[0]);
        newNode->left = buildTree(vector<int>(preorder.begin()+1,preorder.begin()+j+1),vector<int>(inorder.begin(),inorder.begin()+j));
        newNode->right = buildTree(vector<int>(preorder.begin()+j+1,preorder.end()),vector<int>(inorder.begin()+j+1,inorder.end()));
        return newNode;
    }
};