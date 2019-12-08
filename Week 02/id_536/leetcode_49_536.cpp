#include <iostream>
#include <cstring>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    /*****
     解法：哈希表实现
            键：排序后字符串作为键
            值：各字符串
    ******/
    vector< vector<string> > groupAnagrams(vector<string>& strs) {
        vector< vector<string> > res;
        map< string,vector<string> > mapA;
        vector<string>::iterator s;
        for(s=strs.begin();s!=strs.end();++s)
        {
             string temp = *s;
             sort(temp.begin(),temp.end());
             mapA[temp].push_back(*s);
        }
        map< string,vector<string> >::iterator iter;
        for(iter=mapA.begin();iter!=mapA.end();++iter)
            res.push_back(iter->second);
        return res;
    }
};

/****
 以下为测试代码
*****/
int main()
{
    vector<string> strs;
    Solution s;
    vector< vector<string> > res;

    strs.push_back("eat");
    strs.push_back("tea");
    strs.push_back("tan");
    strs.push_back("ate");
    strs.push_back("nat");
    strs.push_back("bat");
    res = s.groupAnagrams(strs);
    vector< vector<string> >::iterator iter;
    int i=0;
    for(iter = res.begin(); iter != res.end(); ++iter)
    {
        cout<<++i<<endl;//计数分隔
        vector<string> temp(*iter);
        vector<string>::iterator it;
        for(it=temp.begin();it!=temp.end();++it)
            cout<< *it<< ",";
        cout<<endl;
    }

    return 0;
}
