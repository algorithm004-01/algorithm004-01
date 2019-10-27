#include <iostream>
#include <vector>
#include <stack>

using namespace std;

//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    /******
     解法1：递归法
             时间复杂度O(n)
             空间复杂度O(n)
    *******/
    void helper1(TreeNode* root,vector<int>& res)
    {
        if(root)
        {
            helper1(root->left,res);
            res.push_back(root->val);
            helper1(root->right,res);
        }
    }

     /******
     解法2：迭代法
            思路：中序遍历为左->根->右
    *******/
    void helper2(TreeNode* root,vector<int>& res)
    {
        stack<TreeNode* > st;
        TreeNode* node = root;
        while(node || !st.empty())
        {
            while(node)//左子树压栈
            {
                st.push(node);
                node = node->left;
            }
            node = st.top();//读左叶子节点
            res.push_back(node->val);
            st.pop();
            node = node->right;
        }
    }

    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        //helper1(root,res);//递归法
        helper2(root,res);//迭代法
        return res;
    }

};

/************以下为测试代码**********************
              1
输入：  2          3      预期结果->4 2 6 5 7 1 8 3 9
      4    5      8  9
          6  7
*************************************************/
int main()
{
    Solution s;
    vector<int> res;
    TreeNode *root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(5);
    root->left->right->left = new TreeNode(6);
    root->left->right->right = new TreeNode(7);
    root->right->left = new TreeNode(8);
    root->right->right = new TreeNode(9);

    res = s.inorderTraversal(root);

    for(int i=0;i<res.size();++i)
        cout<<res[i]<<" ";
    cout<<endl;

    return 0;
}
