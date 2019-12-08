/***题目：先序遍历二叉树***/
#include <iostream>
#include <vector>
#include <stack>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    /********
      解法1：递归法 根-左-右
             时间复杂度O(n)
             空间复杂度O(n)
    *********/
    void helper1(TreeNode* root,vector<int>& res)
    {
         if(root)
         {
             res.push_back(root->val);
             helper1(root->left,res);
             helper1(root->right,res);
         }
    }

    /********
     解法2：迭代法1：从根节点开始，每次迭代弹出当前栈顶元素，
                      并将其孩子节点压入栈中，先压右孩子再压左孩子。
            时间复杂度O(n)
            空间复杂度O(n)
    *********/
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

            if(node->right)
                st.push(node->right);
            if(node->left)
                st.push(node->left);
        }
    }

    /********
     解法3：迭代法2：中序遍历的变种【左根右->根左右】
            时间复杂度O(n)
            空间复杂度O(n)
    *********/
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
                res.push_back(node->val);//先序遍历提前到这里读
                st.push(node);
                node = node->left;
            }
            //res.push_back(node->val);中序遍历在这个位置读
            node = st.top();
            st.pop();
            node = node->right;//进入右子树访问
        }
    }

    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        //helper1(root,res);//递归法
        helper2(root,res);//迭代法1
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

    res = s.preorderTraversal(root);
    for(int i=0;i<res.size();++i)
        cout<<res[i]<<" ";
    cout<<endl;

    return 0;
}
