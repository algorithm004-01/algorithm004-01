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
        vector<int> res;
        _pre(root, res);
        return res;
    }
    
    void _pre(Node* root, vector<int>& res) {
        if (root == NULL) {
            return;
        }
        
        res.push_back(root->val);
        for (const auto& child : root->children) {
            _pre(child, res);
        }
    }
};
