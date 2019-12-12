#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    /*****
     �ⷨ1:DP
           ʱ�临�Ӷ�O(n)
           �ռ临�Ӷ�O(1)
    *****/
    int helper1(vector<int>& nums) {
         int n = nums.size();
         if(n == 1)
            return nums[0];

         int curMax = 1;
         int curMin = 1;
         int res = INT_MIN;

         for(int i=0;i<n;++i)
         {
             if(nums[i] <0)
             {
                 int temp = curMax;
                 curMax = curMin;
                 curMin = temp;
             }
             curMax = max(curMax * nums[i],nums[i]);
             curMin = min(curMin * nums[i],nums[i]);

             res = max(res,curMax);
         }
         return res;
    }

    /*****
     �ⷨ2:DP,�����ݴ���СֵcurMin��
              ÿ�αȽ�3��ֵ����ǰֵ����ǰֵ*���ֵ����ǰֵ*��Сֵ��
           ʱ�临�Ӷ�O(n)
           �ռ临�Ӷ�O(1)
    *****/
    int helper2(vector<int>& nums) {
         int n = nums.size();
         if(n == 1)
            return nums[0];

         int curMax = 1;
         int curMin = 1;
         int res = INT_MIN;

         for(int i=0;i<n;++i)
         {
             int temp1 = curMax * nums[i];
             int temp2 = curMin * nums[i];
             curMax = max(max(temp1,temp2),nums[i]);
             curMin = min(min(temp1,temp2),nums[i]);

             res = max(res,curMax);
         }
         return res;
    }

    /*****
     �ⷨ3:DP,���鱣������ֵ
           ʱ�临�Ӷ�O(n)
           �ռ临�Ӷ�O(n)
    *****/
    int helper3(vector<int>& nums) {
         int n = nums.size();
         if(n == 1)
            return nums[0];

         int dpMax[n];
         int dpMin[n];
         dpMax[0] = nums[0];
         dpMin[0] = nums[0];
         int res = nums[0];

         for(int i=1;i<n;++i)
         {
             int temp1 = dpMax[i-1] * nums[i];
             int temp2 = dpMin[i-1] * nums[i];
             dpMax[i] = max(max(temp1,temp2),nums[i]);
             dpMin[i] = min(min(temp1,temp2),nums[i]);

             res = max(res,dpMax[i]);
         }
         return res;
    }

    int maxProduct(vector<int>& nums) {
        int res;
        //res = helper1(nums);
        //res = helper2(nums);
        res = helper3(nums);
        return res;
    }
};

int main()
{
    Solution s;
    vector<int> nums{2,3,-2,4};//���԰�����Ԥ�ڽ��6
    //vector<int> nums{-2,0,-1};//���԰�����Ԥ�ڽ��0
    int res = s.maxProduct(nums);
    cout << res << endl;
    return 0;
}
