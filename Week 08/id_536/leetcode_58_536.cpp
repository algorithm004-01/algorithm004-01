#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    int lengthOfLastWord(string s) {
        int res = 0;
        for(int i = s.length()-1; i >= 0; --i) {
            if(s[i] != ' ')
                ++ res;
            else {
                if(res)
                    break;
            }
        }
        return res;
    }
};

int main()
{
    Solution s;
    int res = s.lengthOfLastWord("djfks djsjd dd 23234");
    cout << res << endl;
    return 0;
}
