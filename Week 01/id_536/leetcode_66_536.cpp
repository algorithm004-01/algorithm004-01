#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    /*******
    �ⷨ1��������������תΪ��������1��ת������
            �ýⷨ�ᵼ������Խ�磬������Ҫ��
    ******/
    vector<int> plusOne1(vector<int>& digits) {
        int i,temp,ten;
        temp = 0;
        ten = 1;
        vector<int> res;
        for(i = digits.size()-1; i >= 0; --i)
        {
            temp += digits[i] * ten;//תΪ����
            ten *= 10;
        }
        temp += 1;//����ĿҪ���1

        if(temp / ten)  //�ж����λ�Ƿ��λ1
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
    �ⷨ2��ÿλ��ӡ����������
            ��1����ȫ9����1299->1300
            ��2��ȫ9����9999->10000
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
         if(i == -1 && digits[0] == 0)//ȫ9���
         {
             digits.push_back(0);
             digits[0] = 1;
         }
         return digits;
    }
};

/*****
 ���²��Դ���
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
