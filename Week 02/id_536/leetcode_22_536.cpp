#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void helper(int l,int r,string str,int N,vector<string>& res)
    {
       //终结条件
       if(r > l)             //右括号大于左括号个数
          return;
       if(l > N || r > N)    //左括号或右括号大于N
          return;
       if(l == N && r == N)
          res.push_back(str);

       /*当前层处理
         左子树：str1=str+"(";
                 l1=l+1;
                 r1=r;
         右子树：str2=str+")";
                 l2=l;
                 r2=r+1;
       */

       //下一层调用。下一层调用的参数l,r,str即用的当前层处理的值
       helper(l+1,r,str+"(",N,res);
       helper(l,r+1,str+")",N,res);

       //恢复当前层状态
       //无处理
    }

    vector<string> generateParenthesis(int n) {
        vector<string> res;
        helper(0,0,"",n,res);
        return res;
    }
};

/*以下为测试代码*/
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
