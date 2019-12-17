#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    /*******
    解法1：暴力法，数组转为整数，加1后转回数组
            该解法会导致整数越界，不符合要求。
    ******/
    vector<int> plusOne1(vector<int>& digits) {
        int i,temp,ten;
        temp = 0;
        ten = 1;
        vector<int> res;
        for(i = digits.size()-1; i >= 0; --i)
        {
            temp += digits[i] * ten;//转为整数
            ten *= 10;
        }
        temp += 1;//按题目要求加1

        if(temp / ten)  //判断最高位是否进位1
        {
            res.push_back(1);
            temp %= ten;
        }
        ten /= 10;
        while(ten)
        {
            res.push_back(temp/ten);
            temp %= ten;
            ten /= 10;
        }
        return res;
    }

    /******
    解法2：每位相加。两种情况：
            （1）非全9，如1299->1300
            （2）全9，如9999->10000
    ******/
    vector<int> plusOne2(vector<int>& digits) {
         int i;
         for(i=digits.size()-1;i>=0;--i)
         {
             if(digits[i] == 9)
             {
                 digits[i] = 0;
             }
             else
             {
                 digits[i] += 1;
                 break;
             }
         }
         if(i == -1 && digits[0] == 0)//全9情况
         {
             digits.push_back(0);
             digits[0] = 1;
         }
         return digits;
    }
};

/*****
 以下测试代码
****/
int main()
{
    vector<int> nums,res;
    Solution s;
    nums.push_back(9);
    nums.push_back(3);
    nums.push_back(9);
    res = s.plusOne1(nums);
    for(int i=0;i<res.size();++i)
        cout<<res[i]<<",";
    cout<<endl;

    return 0;
}
