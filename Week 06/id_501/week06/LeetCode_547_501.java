package homework.week06;

import java.util.Arrays;

/**
 * 547. 朋友圈
 * https://leetcode-cn.com/problems/friend-circles/
 * @author tangxy
 * @date 2019-11-24
 */
public class LeetCode_547_501 {

    int find(int[] parent,int i){
        if(parent[i] == -1){
            return i;
        }
        return find(parent,parent[i]);
    }
    void union(int[] parent,int x,int y){
        int xset = find(parent,x);
        int yset = find(parent,y);
        if(xset != yset){
            parent[xset] = yset;
        }
    }

    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent,-1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if(M[i][j] == 1 && i != j){
                    union(parent,i,j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if(parent[i] == -1){
                count ++;
            }
        }
        return count;
    }
}
