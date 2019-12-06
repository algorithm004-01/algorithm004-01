#include <iostream>
#include <string>
#include <set>
#include <map>

using namespace std;

class Solution {
public:
    /*****
     解法1：暴力法
            时间复杂度：O(J*S)
            空间复杂度：O(1)
     *****/
    int helper1(string J, string S) {
         int res = 0;
         for(int i = 0; i < S.length(); ++ i) {
            for(int j = 0; j < J.length(); ++ j) {
                if(S[i] == J[j]) {
                    ++ res;
                }
            }
         }
         return res;
    }

    /*****
     解法2：set实现
            时间复杂度：O(J+S)
            空间复杂度：O(J)
     *****/
    int helper2(string J, string S) {
         int res = 0;
         //unordered_set<char> setJ(J.begin(),J.end());
         set<char> setJ(J.begin(),J.end());
         for(int i = 0; i < S.length(); ++i) {
             if(setJ.count(S[i]))
                ++ res;
         }
         return res;
    }

    /*****
     解法3：map实现
            时间复杂度：O(J+S)
            空间复杂度：O(J)
     *****/
    int helper3(string J, string S) {
         int res = 0;
         //unordered_map<char,int> mapJ;
         map<char,int> mapJ;
         for(auto c : J)
            mapJ[c] = 1;
         for(auto c : S)
            res += mapJ[c];
         return res;
    }

    int numJewelsInStones(string J, string S) {
         int res = 0;
         //res = helper1(J,S);
         //res = helper2(J,S);
         res = helper3(J,S);
         return res;
    }
};

int main()
{
    Solution s;
    int res = s.numJewelsInStones("aA","aAAbbbb");
    cout << res << endl;
    return 0;
}
