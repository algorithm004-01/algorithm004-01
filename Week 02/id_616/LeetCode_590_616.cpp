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
        vector<int> result;
        postorderHelper(result, root);
        return result;
    }

    void postorderHelper(vector<int> &result, Node* root){
        if(root == NULL) return;
        for(auto &it : root->children){
            postorderHelper(result, it);
        }
        result.push_back(root->val);
        return;
    }
};