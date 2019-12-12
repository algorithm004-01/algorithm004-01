/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int> result;
        preorderHelper(result, root);
        return result;
    }

    void preorderHelper(vector<int> &result, Node* root){
        if(root == NULL) return;
        result.push_back(root->val);
        for(auto &&it : root->children){
            preorderHelper(result, it);
        }
        return;
    }
};