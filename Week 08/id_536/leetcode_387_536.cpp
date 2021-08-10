#include <iostream>
#include <map>

using namespace std;
//ʱ�临�Ӷȣ�O(n)��nΪ�ַ����ĳ���
//�ռ临�Ӷȣ�O(n)
class Solution {
public:
    int firstUniqChar(string s) {
        //unordered_map<char,int> mapS;
        map<char,int> mapS;
        for(auto c : s)
            ++ mapS[c];
        for(int i = 0; i < s.size(); ++i) {
           if(mapS[s[i]] == 1)
               return i;
        }
        return -1;
    }
};

int main()
{
    Solution s;
    int res = s.firstUniqChar("lol");
    cout << res << endl;
    return 0;
}
