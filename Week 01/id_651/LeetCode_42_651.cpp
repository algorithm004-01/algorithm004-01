/*
    思路
    1. 暴力求解1：按列计算盛水量， 定住一个柱体，然后用遍历左右两边的柱体，找到左右的最高高度。 
                 再获取这个最高高度与当前柱体的高度差，依次遍历完所有柱体即可获得所有的水量.
                 (第一个以及最后一个不需要，因为只有一个右/左柱体)
    2. 头尾双指针移动逼近, 计算当前柱体的高度与头指针，尾指针所在位置高度的大小关系。 移动指针，最后计算出水量

*/
# include <iostream>
# include <windows.h>
# include <vector>
using namespace std;

int trap(vector<int> & height){
    int ans = 0;
    int size = height.size();
    for (int i = 1; i < size - 1;i++){
        int max_left = 0, max_right = 0;
        for (int j = i; j >= 0; j--)
            max_left = max(max_left, height[j]);
        for (int j = i; j < size; j++)
            max_right = max(max_right, height[j]);
        ans += min(max_left, max_right) - height[i];
    }
    return ans;
};

int trap_pointer(vector<int> & height){
    int water = 0;
    int left = 0, right = 0;
    int first = 0, last = height.size() - 1;
    while(first < last){
        if (height[first] < height[last]){
            height[first] >= left ? (left = height[first]) : water += (left - height[first]);
            ++first;
        }
        else{
            height[last] >= right ? (right = height[last]) : water += (right - height[last]);
            --last;
        }
        cout << water << endl;
    }
    return water;
};

int main(){
    vector<int> height;
    height.push_back(0);
    height.push_back(1);
    height.push_back(0);
    height.push_back(2);
    height.push_back(1);
    height.push_back(0);
    height.push_back(1);
    height.push_back(3);
    height.push_back(2);
    height.push_back(1);
    height.push_back(2);
    height.push_back(1);
    cout << trap_pointer(height) << endl;
    Sleep(10000);
    return 0;
}