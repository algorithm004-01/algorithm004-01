/***��Ŀ���������������***/
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
     �ⷨ1���ݹ鷨 ��-��-��
             ʱ�临�Ӷ�O(n)
             �ռ临�Ӷ�O(n)
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
     �ⷨ2��������1����������ⷨ2���֡�
             ����-��-�� reverse��Ϊ ��-��-����
             ʱ�临�Ӷ�O(n)
             �ռ临�Ӷ�O(n)
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
                st.push(node->left);  //����left,rightѹջ˳�������ⷨ2������

            if(node->right)
                st.push(node->right);
        }
        reverse(res.begin(),res.end());//����-��-�󡿽����ת
    }

    /******
     �ⷨ3��������2����������ⷨ3���֡�
             ����-��-�� reverse��Ϊ ��-��-����
             ʱ�临�Ӷ�O(n)
             �ռ临�Ӷ�O(n)
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
                node = node->right;     //�������������left
            }
            node = st.top();
            st.pop();
            node = node->left;         //�������������right
        }
        reverse(res.begin(),res.end());//����-��-�󡿽����ת
    }

    vector<int> postorderTraversal(TreeNode* root) {
         vector<int> res;
        //helper1(root,res);//�ݹ鷨
        helper3(root,res);//������2
        return res;
    }
};

/*********
����Ϊ���Դ���
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
