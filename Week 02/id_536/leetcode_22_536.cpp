#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void helper(int l,int r,string str,int N,vector<string>& res)
    {
       //�ս�����
       if(r > l)             //�����Ŵ��������Ÿ���
          return;
       if(l > N || r > N)    //�����Ż������Ŵ���N
          return;
       if(l == N && r == N)
          res.push_back(str);

       /*��ǰ�㴦��
         ��������str1=str+"(";
                 l1=l+1;
                 r1=r;
         ��������str2=str+")";
                 l2=l;
                 r2=r+1;
       */

       //��һ����á���һ����õĲ���l,r,str���õĵ�ǰ�㴦���ֵ
       helper(l+1,r,str+"(",N,res);
       helper(l,r+1,str+")",N,res);

       //�ָ���ǰ��״̬
       //�޴���
    }

    vector<string> generateParenthesis(int n) {
        vector<string> res;
        helper(0,0,"",n,res);
        return res;
    }
};

/*����Ϊ���Դ���*/
int main()
{
    Solution s;
    vector<string> res;
    int n = 3;
    res = s.generateParenthesis(3);
    for(int i=0;i<res.size();++i)
        cout<<res[i]<<endl;
    return 0;
}
