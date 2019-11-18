#include <iostream>

using namespace std;

class Solution {
public:
    //��ͨ����
    int binarySearch1(int x)
    {
        if(x == 0 || x ==1)
            return x;
        long left,right,mid,temp;
        left = 0;
        right = x;
        while(left <= right)
        {
            mid = left + (right - left)/2;
            temp = mid * mid;
            if(temp == x)
                return mid;
            else if(temp < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left-1;//ͨ��ģ�巵��-1
    }

    //���߽����
    int binarySearch2(int x) {
        if(x == 0 || x ==1)
            return x;
        long left,right,mid,temp;
        left = 0;
        right = x;
        while(left < right)
        {
            mid = left + (right - left)/2;
            temp = mid * mid;
            if(temp == x)
                right = mid;
            else if(temp < x)
                left = mid + 1;
            else
                right = mid;
        }
        if(left*left == x)
           return left;
        else
            return left - 1;//ͨ��ģ�巵��-1
    }

    //�Ҳ�߽����
    int binarySearch3(int x) {
        if(x == 0 || x ==1)
            return x;
        long left,right,mid,temp;
        left = 0;
        right = x;
        while(left < right)
        {
            mid = left + (right - left)/2;
            temp = mid * mid;
            if(temp == x)
                left = mid + 1;
            else if(temp < x)
                left = mid + 1;
            else
                right = mid;
        }
        return left-1;
    }

    int mySqrt(int x) {
        int res;
        res = binarySearch1(x);
        //res = binarySearch2(x);
        //res = binarySearch3(x);
        return res;
    }
};

//����Ϊ���Դ���
int main()
{
    Solution s;
    cout << s.mySqrt(8) << endl;
    cout << s.binarySearch4(8) << endl;
    return 0;
}
