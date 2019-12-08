#include <iostream>

using namespace std;

class Solution {
public:
    /*****
    解法1：模拟十转二进制、取模
           时间复杂度：O(1)
           空间复杂度：O(1)
    *******/
    int helper1(uint32_t n) {
        int res = 0;
        while(n) {
            //if(n % 2)
            if(n & 1)
                ++ res;
            n >>= 1;
        }
        return res;
    }

    /*****
    解法2：循环与位移动
           时间复杂度：O(1)
           空间复杂度：O(1)
    *******/
    int helper2(uint32_t n) {
        int res = 0;
        uint32_t mask = 1;
        for(int i = 0; i < 32; ++i) {
            if(n & mask)
                ++ res;
            mask <<= 1;
        }
        return res;
    }

    /*****
    解法3：位操作技巧
           时间复杂度：O(1)
           空间复杂度：O(1)
    *******/
    int helper3(uint32_t n) {
        int res = 0;
        while(n) {
            ++ res;
            n &= (n - 1);//将 n和n-1做与运算，会把最后一个1的位变成0
        }
        return res;
    }

    int hammingWeight(uint32_t n) {
        int res;
        //res = helper1(n);//模拟十进制转二进制，执行用时0ms
        res = helper2(n);//循环与位移动，执行用时8ms
        //res = helper3(n);//位操作技巧，执行用时4ms
        return res;
    }
};

int main()
{
    Solution s;
    uint32_t n = 00000000000000000000000000001011;
    int res = s.hammingWeight(n);
    cout << res << endl;
    return 0;
}
