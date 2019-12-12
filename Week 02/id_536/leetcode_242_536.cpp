#include <iostream>
#include <map>
#include <cstring>
#include <algorithm>

using namespace std;

class Solution {
public:
    /*******
     �ⷨ1�������������ź��ٱȽ�
             ʱ�临�Ӷȣ�O(nlogn)
             �ռ临�Ӷȣ�O(1)
    *******/
    bool isAnagram1(string s, string t) {
        if(s.size() != t.size())
            return false;
        sort(s.begin(),s.end());
        sort(t.begin(),t.end());
        return s == t;
     }

    /*******
     �ⷨ2����ϣ��ⷨ1�������ַ���������ĸ���ִ������бȽ�
             ʱ�临�Ӷȣ�O(n)
             �ռ临�Ӷȣ�O(1)
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
             if(--mapA[t[j]] < 0)//��ĸͳ�ƴ�������0�����
                return false;
         }
         return true;
    }

    /*******
     �ⷨ3����ϣ��ⷨ2,�ⷨ2�����ƽⷨ
             ʱ�临�Ӷȣ�O(n)
             �ռ临�Ӷȣ�O(1)
    *******/
     bool isAnagram3(string s, string t) {
         map<char,int> mapA;
         if(s.size() != t.size())
            return false;
         for(int i=0;i<s.size();++i)
         {
             ++mapA[s[i]];
             --mapA[t[i]];//��Ϊs,t������ȣ����Է�һ��ѭ��
         }
         for(map<char,int>::iterator iter=mapA.begin();iter!=mapA.end();++iter)
         {
             if(iter->second < 0)//��ĸͳ�ƴ�������0�����
                return false;
         }
         return true;
    }
};

/*******
����Ϊ���Դ���
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
