#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    /*****
     解法1：动态规划
             1、状态定义P(x)：x换算成二进制后1的个数
             2、状态方程：P(x) = P(x/2) + x%2;
             3、初始化：P(0) = 0;
             时间复杂度：O(n)
             空间复杂度：O(n)
    ******/
    vector<int> helper1(int num) {
         vector<int> res(num+1);
         res[0] = 0;
         for(int i = 1; i <= num; ++ i) {
            res[i] = res[i >> 1] + (i & 1);
         }
         return res;
    }

    /*****
     解法2：动态规划
             1、状态定义P(x)：x换算成二进制后1的个数
             2、状态方程：P(x) = P(x&(x-1)) + 1;
             3、初始化：P(0) = 0;
             时间复杂度：O(n)
             空间复杂度：O(n)
    ******/
    vector<int> helper2(int num) {
        vector<int> res(num+1);
         res[0] = 0;
         for(int i = 1; i <= num; ++ i) {
            res[i] = res[i & (i-1)] + 1;
         }
         return res;
    }

    vector<int> countBits(int num) {
         vector<int> res;
         //res = helper1(num);
         res = helper2(num);
         return res;
    }
};

int main()
{
    Solution s;
    vector<int> res = s.countBits(5);
    for(int i = 0; i< res.size(); ++ i)
        cout << res[i];
    return 0;
}
