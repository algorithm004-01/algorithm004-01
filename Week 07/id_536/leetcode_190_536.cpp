#include <iostream>

using namespace std;

class Solution {
public:
    /*****
     解法1：位操作技巧
    ******/
    uint32_t helper1(uint32_t n) {
         uint32_t res = 0;
         for(int i = 0; i< 32; ++i) {
            res <<= 1;
            res += n & 1;
            n >>= 1;
         }
         return res;
    }

    uint32_t reverseBits(uint32_t n) {
        uint32_t res;
        res = helper1(n);
        return res;
    }
};

int main()
{
    Solution s;
    uint32_t res = s.reverseBits(00000010100101000001111010011100);
    cout << res << endl;
    return 0;
}
