/***��Ŀ���������������***/
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
      �ⷨ1���ݹ鷨 ��-��-��
             ʱ�临�Ӷ�O(n)
             �ռ临�Ӷ�O(n)
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
     �ⷨ2��������1���Ӹ��ڵ㿪ʼ��ÿ�ε���������ǰջ��Ԫ�أ�
                      �����亢�ӽڵ�ѹ��ջ�У���ѹ�Һ�����ѹ���ӡ�
            ʱ�临�Ӷ�O(n)
            �ռ临�Ӷ�O(n)
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
     �ⷨ3��������2����������ı��֡������->�����ҡ�
            ʱ�临�Ӷ�O(n)
            �ռ临�Ӷ�O(n)
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
                res.push_back(node->val);//���������ǰ�������
                st.push(node);
                node = node->left;
            }
            //res.push_back(node->val);������������λ�ö�
            node = st.top();
            st.pop();
            node = node->right;//��������������
        }
    }

    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        //helper1(root,res);//�ݹ鷨
        helper2(root,res);//������1
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

    res = s.preorderTraversal(root);
    for(int i=0;i<res.size();++i)
        cout<<res[i]<<" ";
    cout<<endl;

    return 0;
}
