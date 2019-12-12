#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    /*****
     �ⷨ1����̬�滮
             1��״̬����P(x)��x����ɶ����ƺ�1�ĸ���
             2��״̬���̣�P(x) = P(x/2) + x%2;
             3����ʼ����P(0) = 0;
             ʱ�临�Ӷȣ�O(n)
             �ռ临�Ӷȣ�O(n)
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
     �ⷨ2����̬�滮
             1��״̬����P(x)��x����ɶ����ƺ�1�ĸ���
             2��״̬���̣�P(x) = P(x&(x-1)) + 1;
             3����ʼ����P(0) = 0;
             ʱ�临�Ӷȣ�O(n)
             �ռ临�Ӷȣ�O(n)
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
