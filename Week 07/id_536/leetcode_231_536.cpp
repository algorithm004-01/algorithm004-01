#include <iostream>

using namespace std;

class Solution {
public:
    /*****
     �ⷨ1��λ�������ɣ�������1�����������1
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
     �ⷨ2��λ��������
    ******/
    bool helper2(int n) {
        return (n&(n-1)) == 0;
    }

    /*****
     �ⷨ3��ģ��ʮ����ת�����ƣ�ȡģ
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
