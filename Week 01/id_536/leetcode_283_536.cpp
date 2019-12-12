#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    /*********
      �ⷨ1��˫ָ�뷨
    ********/
    void moveZeroes1(vector<int>& nums) {
        int i,j,k;
        j=0;
        for(i=0;i<nums.size();i++)
        {
            if(nums[i] != 0)
                nums[j++] = nums[i];
        }
        for(k=j;k<nums.size();k++)
            nums[k] = 0;
        }

    /***********
    �ⷨ2��������������Ҫ�������飬��������ĿҪ��
    ************/
    void moveZeroes2(vector<int>& nums) {
        int i,j,k;
        vector<int> numsAns;
        j=0;
        for(i=0;i<nums.size();i++)
        {
            if(nums[i] != 0)
            {
                numsAns.push_back(nums[i]);
                j++;//��0����
            }
        }
        k=nums.size()-j;//0����
        while(k--)
            numsAns.push_back(0);
        for(i=0;i<nums.size();i++)
            nums[i]=numsAns[i];
    }

};

int main()
{
    Solution s;
    vector<int> nums;
    /*******
     ���²�����֤
    *****/
    nums.push_back(0);
    nums.push_back(1);
    nums.push_back(0);
    nums.push_back(3);
    nums.push_back(12);
    s.moveZeroes2(nums);
    for(int i=0;i<nums.size();i++)
      cout<<nums[i]<<",";
    cout<<endl;
    return 0;
}
