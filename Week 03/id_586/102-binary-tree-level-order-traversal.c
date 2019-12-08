/*
# 102 二叉树的层次遍历

给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如: 给定二叉树: [3,9,20,null,null,15,7],
     3
    / \
    9  20
      /  \
     15   7

返回其层次遍历结果：

    [
        [3],
        [9,20],
        [15,7]
    ]

*/
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution1 {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ret;

        if (!root) return ret;

        queue<TreeNode*> q;
        TreeNode *curr;

        q.push(root);

        while(q.empty() == 0) {
            vector<int> level;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                curr = q.front();
                level.push_back(curr->val);
                q.pop();
                if (curr->left) q.push(curr->left);
                if (curr->right) q.push(curr->right);
            }
            ret.push_back(level);
        }

        return ret;
    }
};

/*
 * 方法2： 使用递归的方法
 * */
class Solution2 {
public:
    vector<vector<int>> ret;

    void buildVector(TreeNode *root, int depth)
    {
        if(root == NULL) return;
        /* start the current level */
        if(ret.size() == depth)
            ret.push_back(vector<int>());

        /* fulfil the current level */
        ret[depth].push_back(root->val);

        /* process child nodes for the next level */
        buildVector(root->left, depth + 1);
        buildVector(root->right, depth + 1);
    }

    vector<vector<int> > levelOrder(TreeNode *root) {
        buildVector(root, 0);
        return ret;
    }
}；
