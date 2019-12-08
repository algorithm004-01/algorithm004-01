/***
 二分查找模板：
int binarySearch(vector<int> &num,int target)
 int left = 0;
 int right = ...;
 while(...)
 {
    int mid = (left + right)/2;
    if(nums[mid] == target)
        ...
    else if(nums[mid] < target);
        ...
    else if(nums[mid] > target);
        ...
 }
    return ...;
***/
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    /******
      解法1：普通二分
      时间复杂度:O(n)
      空间复杂度:O(1)
      *****/
    int binarySearch1(vector<int>& nums, int target)
    {
        int left = 0;
        int right = nums.size() - 1;
        while( left <= right )
        {
            int mid = left + (right - left)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }

    /******
      解法2：左侧边界二分
      时间复杂度:O(n)
      空间复杂度:O(1)
      *****/
    int binarySearch2(vector<int>& nums, int target)
    {
        int left = 0;
        int right = nums.size();
        while(left < right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] == target)
                right = mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid;
        }
        if(left == nums.size())
            return -1;
        if(nums[left] == target)
            return left;
        else
            return -1;
    }

    /******
      解法3：右侧边界二分
      时间复杂度:O(n)
      空间复杂度:O(1)
      *****/
    int binarySearch3(vector<int>& nums, int target)
    {
        int left = 0;
        int right = nums.size();
        while(left < right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] == target)
                left = mid + 1;
            else if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid;
        }
        if(left == 0)
            return -1;
        if(nums[left-1] == target)
            return left-1;
        else
            return -1;
    }

    int search(vector<int>& nums, int target) {
        int res;
        res = binarySearch1(nums,target);//普通二分
        //res = binarySearch2(nums,target);//左侧边界二分
        //res = binarySearch3(nums,target);//右侧边界二分
        return res;
    }
};

int main()
{
    Solution s;
    vector<int> nums;
    int target = 9;
    int res;
    nums.push_back(-1);
    nums.push_back(0);
    nums.push_back(3);
    nums.push_back(5);
    nums.push_back(9);
    nums.push_back(12);
    res = s.search(nums,target);
    cout <<res << endl;
    return 0;
}
