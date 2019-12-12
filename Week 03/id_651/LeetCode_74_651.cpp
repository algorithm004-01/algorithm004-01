/*
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1:
输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
输出: false

思路： 
    1. 暴力法1： 双重遍历。 查找元素
    2. 暴力法2：拼接成一个数组，然后用二分法查找
    3. 将二维数组具象成一个一维数组,二分法查找
*/
# include <iostream>
# include <windows.h>
# include <vector>
using namespace std;

class Solution {
public:
    // 暴力法1
    bool searchMatrix1(vector<vector<int>>& matrix, int target) {
        
        for (int i=0;i< matrix.size();i++){
            for(int j=0; j< matrix[i].size();j++){
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
    // 暴力法2
    bool searchMatrix2(vector<vector<int>>& matrix, int target) {
        vector<int> result;
        for(int i=0;i<matrix.size();i++)
            result.insert(result.end(),matrix[i].begin(), matrix[i].end());
        int left = 0;
        int right = result.size()-1;
        while (left <= right){
            int mid = (right + left) / 2;
            cout << mid;
            if (result[mid] == target) return true;
            else if (result[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
    // 具象成一个数组，进行二分查找
    bool searchMatrix2(vector<vector<int>>& matrix, int target) {
        int n = matrix.size();
        // 需要判断下空数组的情况
        if (n == 0) return false;
        int m = matrix[0].size();
        // 需要判断下空数组的情况
        if (m == 0) return false;
        int l = 0, r = m * n - 1;
        while (l != r){
            int mid = (l + r - 1) >> 1;
            if (matrix[mid / m][mid % m] < target)
                l = mid + 1;
            else 
                r = mid;
        }
        return matrix[r / m][r % m] == target;
    }
}


int main(){
    Solution sol;
    return 0;
}