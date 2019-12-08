#include <iostream>
#include <map>
#include <cstring>
#include <algorithm>

using namespace std;

class Solution {
public:
    /*******
     解法1：暴力法，快排后再比较
             时间复杂度：O(nlogn)
             空间复杂度：O(1)
    *******/
    bool isAnagram1(string s, string t) {
        if(s.size() != t.size())
            return false;
        sort(s.begin(),s.end());
        sort(t.begin(),t.end());
        return s == t;
     }

    /*******
     解法2：哈希表解法1，两个字符串各个字母出现次数进行比较
             时间复杂度：O(n)
             空间复杂度：O(1)
    *******/
     bool isAnagram2(string s, string t) {
         map<char,int> mapA;
         if(s.size() != t.size())
            return false;
         for(int i=0;i<s.size();++i)
         {
             ++mapA[s[i]];
         }
         for(int j=0;j<t.size();++j)
         {
             if(--mapA[t[j]] < 0)//字母统计存在少于0的情况
                return false;
         }
         return true;
    }

    /*******
     解法3：哈希表解法2,解法2的类似解法
             时间复杂度：O(n)
             空间复杂度：O(1)
    *******/
     bool isAnagram3(string s, string t) {
         map<char,int> mapA;
         if(s.size() != t.size())
            return false;
         for(int i=0;i<s.size();++i)
         {
             ++mapA[s[i]];
             --mapA[t[i]];//因为s,t长度相等，可以放一个循环
         }
         for(map<char,int>::iterator iter=mapA.begin();iter!=mapA.end();++iter)
         {
             if(iter->second < 0)//字母统计存在少于0的情况
                return false;
         }
         return true;
    }
};

/*******
以下为测试代码
*******/
int main()
{
    class Solution ss;
    string s = "abccd";
    string t = "ccabd";
    if(ss.isAnagram2(s,t))
        cout<<"true"<<endl;
    else
        cout<<"false"<<endl;
    return 0;
}
