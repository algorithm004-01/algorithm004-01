/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是 O(log n) 级别。
示例 1:
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1

*/
# include <iostream>
# include <windows.h>
# include <vector>
using namespace std;

class Solution {
public:
    //判断左右边界的值和当前中间值的大小
    //在进行中间值和目标值的大小比较
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[right]){
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
            else{
                if (target < nums[mid] && target >= nums[left]) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }
}

int main(){
    Solution sol;
    return 0;
}