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
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        _dfs(0, root, res);
        return res;
    }
    
    void _dfs(int level, Node* root, vector<vector<int>>& m) {
        if (root == NULL) {
            return;
        }
        
        if (level == m.size())
            m.push_back({});
        m[level].push_back(root->val);
        for (const auto& child : root->children) {
            _dfs(level + 1, child, m);
        }
    }
};
