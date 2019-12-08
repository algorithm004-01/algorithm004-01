#include <iostream>

using namespace std;

class Solution {
public:
    /*****
     解法1：位操作技巧，二进制1个数必须等于1
    ******/
    bool helper1(int n) {
        int cnt = 0;
        while(n) {
            ++ cnt;
            n &= (n-1);
            if(cnt == 2)
                return false;
        }
        return true;
    }

    /*****
     解法2：位操作技巧
    ******/
    bool helper2(int n) {
        return (n&(n-1)) == 0;
    }

    /*****
     解法3：模拟十进制转二进制，取模
    ******/
    bool helper3(int n) {
        int cnt = 0;
        while(n) {
            if(n & 1)
               ++ cnt;
            n >>= 1;
            if(cnt == 2)
                return false;
        }
        return true;
    }

    bool isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        bool res;
        //res = helper1(n);
        res = helper2(n);
        //res = helper3(n);
        return res;
    }
};

int main()
{
    Solution s;
    bool res = s.isPowerOfTwo(2);
    if(res)
        cout << "true" << endl;
    else
        cout << "false" << endl;
    return 0;
}
