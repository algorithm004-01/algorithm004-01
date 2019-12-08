package sf.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LynnSun on 2019/11/23.
 * 力扣题目地址：https://leetcode-cn.com/problems/n-queens
 */
public class NQueens {
    private List<List<String>> results = new ArrayList<>(); // 结果集
    public List<List<String>> solveNQueens(int n) {
        int[] result = new int[n]; // 记录每一行皇后放置的 列坐标
        backtracking(result, 0);
        return results;
    }
    private void backtracking(int[] result,int n){
        if (n == result.length) { // 已放置完，每一行皇后都符合要求
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < result.length; i++) {
                char[] str = new char[n];
                Arrays.fill(str, '.');
                str[result[i]] = 'Q';
                temp.add(new String(str)); // 根据每一行出现皇后的位置填充解
            }
            results.add(temp); // 加入当前解
        }
        for (int i = 0; i < result.length; i++) {
            if (isValidation(result, n, i)) { // 验证是否合法
                result[n] = i; // 记录放置坐标
                backtracking(result, n + 1); // 放置下一行皇后
            }
        }
    }
    // 验证，无同行/同列棋子
    // 对角线无棋子
    private boolean isValidation(int[] result, int row, int col) {
        for (int i = 0; i < row; i++) { // 第一行可以放任意位置
            int sub = row - i; // 行数差
            // 避免同列、对角线出现皇后
            if (result[i]==col||result[i]==col-sub||result[i]==col+sub) {
                return false;
            }
        }
        return true;
    }
}
