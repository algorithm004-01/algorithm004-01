/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
输入: n = 4, k = 2
输出:
    [
    [2,4],
    [3,4],
    [2,3],
    [1,2],
    [1,3],
    [1,4],
    ]
*/

/*  解法1： 回溯+剪枝 
    -> 先生成对应数量的初始key-value对， 将生成的对象vector丢入递归函数中
    -> 递归的跳出条件为： vector的大小等于k的时候。 将结果插入结果vector中
    -> 遍历vector， 先将当前的vector存储一份（便于回溯）, 然后通过剪枝的方式，从中抽取掉迭代值位置的值
    -> 每次递归完当前层的数据之后， 需要回复状态，进行下一层的循环

    解法2： 维护栈
    -> 初始化一个长度为k，每个值为0的vector， 初始化一个指针i=0
    -> 指针在0和1位置移动
    -> 每次循环
        判断vector[i]的值是否大于长度n， 大于则左移
        判断i的值是否等于k-1, 是则将结果插入到结果vector中
        剩余的情况则需要继续增加值,将1位置的值持续的加1
    -> eg:n=3,k=2
        (1,1,0,0)
        (1,2,0,0)
        (1,3,0,0)->准备指针左移
        (2,1,0,0)
        (2,2,0,0)
        (2,3,0,0)
        (3,1,0,0)
        (3,2,0,0)
        (3,3,0,0)
    一直到指针i的值小于0则跳出循环，返回结果
*/   
# include <iostream>
# include <vector>
using namespace std;

class Solution {
private:
    vector<vector<int>> answers;
public:
    // 递归
    vector<vector<int>> combine(int n, int k) {
        vector<int> nums(n, {(1,n)});
        for(int i=0; i<nums.size();i++){
            nums[i] = i+1;
        }
        recursion(nums, k, 0);
        return answers;
    };
    void recursion(vector<int> nums, int k, int pos){
        if(nums.size() == k){answers.push_back(nums);return;};
        for(int i=pos;i<nums.size();i++){
            vector<int> temp(nums);
            nums.erase(nums.begin() + i);
            recursion(nums, k, i);
            nums = temp;
        }
    }


    // 利用栈
    vector<vector<int>> combine2(int n, int k) {
        vector<vector<int>> result;
        int i = 0;
        vector<int> temp(k, 0);
        while(i >= 0){
            temp[i]++;
            if (temp[i] > n) --i;
            else if (i == k-1) result.push_back(temp);
            else{
                ++i;
                temp[i] = temp[i-1];
            }
        }
        return result;
    };
};

int main(){
    Solution sol;
    vector<vector<int>> result;
    result = sol.combine(10, 2);
    for(int i=0; i< result.size(); i++){
        for(int j=0;j< result[i].size();j++){
            cout << result[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}