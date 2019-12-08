/***题目：后序遍历二叉树***/
#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>

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
     解法1：递归法 左-右-根
             时间复杂度O(n)
             空间复杂度O(n)
    *******/
    void helper1(TreeNode* root,vector<int>& res)
    {
        if(root)
        {
            helper1(root->left,res);
            helper1(root->right,res);
            res.push_back(root->val);
        }
    }

    /******
     解法2：迭代法1：先序遍历解法2变种。
             【根-右-左 reverse后为 左-右-根】
             时间复杂度O(n)
             空间复杂度O(n)
    *******/
    void helper2(TreeNode* root,vector<int>& res)
    {
        if(root == NULL)
            return;

        stack<TreeNode* > st;
        TreeNode* node = root;
        st.push(node);
        while(!st.empty())
        {
            node = st.top();
            res.push_back(node->val);
            st.pop();

            if(node->left)
                st.push(node->left);  //这里left,right压栈顺序和先序解法2调换下

            if(node->right)
                st.push(node->right);
        }
        reverse(res.begin(),res.end());//【根-右-左】结果反转
    }

    /******
     解法3：迭代法2：先序遍历解法3变种。
             【根-右-左 reverse后为 左-右-根】
             时间复杂度O(n)
             空间复杂度O(n)
    *******/
    void helper3(TreeNode* root,vector<int>& res)
    {
        if(root == NULL)
            return;

        stack<TreeNode* > st;
        TreeNode* node = root;
        while(node || !st.empty())
        {
            while(node)
            {
                res.push_back(node->val);
                st.push(node);
                node = node->right;     //先序遍历这里是left
            }
            node = st.top();
            st.pop();
            node = node->left;         //先序遍历这里是right
        }
        reverse(res.begin(),res.end());//【根-右-左】结果反转
    }

    vector<int> postorderTraversal(TreeNode* root) {
         vector<int> res;
        //helper1(root,res);//递归法
        helper3(root,res);//迭代法2
        return res;
    }
};

/*********
以下为测试代码
*********/
int main()
{
    Solution s;
    vector<int> res;
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);

    res = s.postorderTraversal(root);
    for(int i=0;i<res.size();++i)
        cout<<res[i]<<" ";
    cout<<endl;

    return 0;
}
