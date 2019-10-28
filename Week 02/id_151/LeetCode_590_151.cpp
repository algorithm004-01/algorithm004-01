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
    vector<int> postorder(Node* root) {
        vector<int> res;
        _post(root, res);
        return res;
    }
    
    void _post(Node* root, vector<int>& res) {
        if (root == NULL) {
            return;
        }
        
        for (const auto& child : root->children) {
            _post(child, res);
        }
        res.push_back(root->val);
    }
};
