#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    /*****
     解法1:DP
           时间复杂度O(n)
           空间复杂度O(1)
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
     解法2:DP,增加暂存最小值curMin，
              每次比较3个值（当前值，当前值*最大值，当前值*最小值）
           时间复杂度O(n)
           空间复杂度O(1)
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
     解法3:DP,数组保存所有值
           时间复杂度O(n)
           空间复杂度O(n)
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
    vector<int> nums{2,3,-2,4};//测试案例，预期结果6
    //vector<int> nums{-2,0,-1};//测试案例，预期结果0
    int res = s.maxProduct(nums);
    cout << res << endl;
    return 0;
}
