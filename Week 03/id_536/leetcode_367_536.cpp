#include <iostream>

using namespace std;

class Solution {
public:
    /*****
     �ⷨ1����ͨ���ַ�
            ʱ�临�Ӷȣ�O(logn),nΪnumֵ
            �ռ临�Ӷȣ�O(1)
    *****/
    bool helper1(int num) {
        long long left = 0;
        long long right = num;
        while(left <= right)
        {
            long long mid = left + (right - left)/2;
            long long temp = mid*mid;
            if(temp == num)
                return true;
            else if(temp < num)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
    bool isPerfectSquare(int num) {
        return helper1(num);
    }
};

int main()
{
    Solution s;
    if(s.isPerfectSquare(13))
        cout << "True" << endl;
    else
        cout << "False" << endl;
    return 0;
}
