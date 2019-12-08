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
        vector<int> nodes;
        recPostOrder(root, nodes);
        return nodes;
    }
    
private:
    void  recPostOrder(Node* root, vector<int> &nodes){
        if(root == NULL){
            return;
        }
        for(Node* child : root->children){
            recPostOrder(child, nodes);
        }
        nodes.push_back(root->val);        
    }
};