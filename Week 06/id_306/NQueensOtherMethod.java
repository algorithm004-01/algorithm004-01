package sf.week6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LynnSun on 2019/11/23.
 * https://leetcode-cn.com/problems/n-queens/solution/javahui-su-fa-si-lu-jian-dan-qing-xi-qing-kan-dai-/
 */
public class NQueensOtherMethod {
    // 思路清晰借鉴一下
    List<List<String>> lists = new ArrayList<>();//返回集合
    List<String> ans = new ArrayList<>();//n皇后的解
    public List<List<String>> solveNQueens(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){//......
            sb.append(".");
        }
        //列的大小为n,主对角线和次对角线的大小为2n-1
        queens(n, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], sb,0);
        return lists;
    }
    void queens(int n,boolean[] y,boolean[] w,boolean[] wc,StringBuilder sb,int i){
        if(ans.size() == n){//递归结束条件，即n皇后已放置所有的行中
            lists.add(new ArrayList<>(ans));
            return;
        }
        for(int j = 0; j < n; j++){
            //判断当前位置是否可用，即列、主对角线、次对角线是否被使用
            if(y[j] || w[n - 1 - i + j] || wc[i + j]) continue;
            //如果可用，先标记该列、主对角线、次对角线已被使用
            y[j] = true;
            w[n - 1 - i + j] = true;
            wc[i + j] = true;
            ans.add(new StringBuilder(sb).replace(j,j+1,"Q").toString());
            //递归下一行是否可以放置皇后，直到所有皇后都放到对应的位置或者该行无法放置皇后则结束
            queens(n,y,w,wc,sb,i+1);
            //递归完成之后，恢复现场
            ans.remove(i);
            y[j] = false;
            wc[i + j] = false;
            w[n - 1 - i + j] = false;
        }
    }
}
