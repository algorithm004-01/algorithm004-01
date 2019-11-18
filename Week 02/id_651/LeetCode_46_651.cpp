/*
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/    

/*
    解法： 递归,回溯, 
    移动索引, 通过交换位置来去重
*/
# include <iostream>
# include <vector>
using namespace std;
class Solution {
private:
    vector<vector<int>> answers;
public:
    vector<vector<int>> permute(vector<int>& nums) {
        recursion(nums, 0);
        return answers;
    };
    void recursion(vector<int> nums, int pos){
        if (pos == nums.size()){
            answers.push_back(nums);
            return;
        }
        for(int j=pos;j<nums.size();j++){
            if (pos != j) swap(nums[pos], nums[j]);
            recursion(nums, pos + 1);
            if (pos != j) swap(nums[pos], nums[j]);
        }
    }
    
};

int main(){
    Solution sol;
    vector<int> n(4,0);
    for(int i=0; i<n.size();i++) n[i] = i;
    vector<vector<int>> answers;
    answers = sol.permute(n);
    return 0;
}