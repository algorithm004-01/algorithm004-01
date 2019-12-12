#include <iostream>

using namespace std;

class Solution {
public:
    /*****
    �ⷨ1��ģ��ʮת�����ơ�ȡģ
           ʱ�临�Ӷȣ�O(1)
           �ռ临�Ӷȣ�O(1)
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
    �ⷨ2��ѭ����λ�ƶ�
           ʱ�临�Ӷȣ�O(1)
           �ռ临�Ӷȣ�O(1)
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
    �ⷨ3��λ��������
           ʱ�临�Ӷȣ�O(1)
           �ռ临�Ӷȣ�O(1)
    *******/
    int helper3(uint32_t n) {
        int res = 0;
        while(n) {
            ++ res;
            n &= (n - 1);//�� n��n-1�������㣬������һ��1��λ���0
        }
        return res;
    }

    int hammingWeight(uint32_t n) {
        int res;
        //res = helper1(n);//ģ��ʮ����ת�����ƣ�ִ����ʱ0ms
        res = helper2(n);//ѭ����λ�ƶ���ִ����ʱ8ms
        //res = helper3(n);//λ�������ɣ�ִ����ʱ4ms
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
