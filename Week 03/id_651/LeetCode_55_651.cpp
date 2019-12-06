/*
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。


思路:
    用一个变量记录位置，然后直接遍历列表，计算该索引能够跳到的位置与变量的大小。
    如果遍历完还没有，则是false
*/
# include <iostream>
# include <windows.h>
# include <vector>
using namespace std;

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int k=0;
        for(int i=0;i<nums.size();i++){
            if (i>k)return false;
            k = max(k,i+nums[i]);
        }
        return true;
    }
}


int main(){
    Solution sol;
    return 0;
}