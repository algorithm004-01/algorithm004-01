package combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        //特殊情况判断
        if(n <= 0 || k <= 0 || n < k) return res;
        findCombinations(n,k,1,new Stack<>());
        return res;
    }

    private void findCombinations(int n, int k, int index, Stack<Integer> s) {
        if(s.size() == k){
            res.add(new ArrayList<>(s));
            return;
        }
        // k - s.size() 为剩下需要寻找的个数
        for (int i = index; i <= n - (k - s.size())+1;i++){
            s.push(i);
            findCombinations(n,k,i+1,s);
            s.pop();
        }
    }
}