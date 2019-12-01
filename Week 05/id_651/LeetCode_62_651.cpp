/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

思路：
    子问题 -> 计算当前的格子有几种走法,  同上阶梯的问题。 求f(n-2) + f(n-1)，
                只是在维度上有所变化, 属于二维以上的范畴
    1. 解法一： 一维数组的解法， 第一行/列走到当前行/列的尽头的走法只有一种，设置为 [1] * n
    通过当前数组和修改后的数组的值相加， 最后获取到走到终点的走法之和

    2. 解法二： 二维数组的解法, 当前格子的走法=左边的走法+上面的走法
    

*/
# include <iostream>
# include <windows.h>
# include <vector>
using namespace std;

class Solution {
public:
    int uniquePaths1(int m, int n) {
        vector<int> result;
        result.assign(n,1);
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                result[j] += result[j-1];
            }
        }
        return result.back();
    }
    int uniquePaths2(int m, int n) {
        vector<vector <int>> result(m, vector<int>(n, 1));
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++) 
                result[i][j] = result[i-1][j] + result[i][j-1];
        }
        return result[m-1][n-1];
    }
};

int main(){
    Solution sol;
    return 0;
}