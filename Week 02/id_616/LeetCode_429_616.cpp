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
        vector<vector<int>> result;
        levelOrderHelper(result, 0, root);
        return result;
    }

    void levelOrderHelper(vector<vector<int>> &result, int level, Node* root){
        if(root == NULL) return;
        if(result.size() <= level) result.resize(level + 1);
        for(auto &it : root->children){
            levelOrderHelper(result, level + 1, it);
        }
        result[level].push_back(root->val);
        return;
    }
};