package LeetCode_52_041;

class Solution {
    int count;
    int size;
    public int totalNQueens(int n) {
        count = 0;
        size =(1 << n) -1;
        solve(0,0,0);
        return count;
    }
    public void solve(int row, int ld,int rd){
        if(row == size){
            count ++;
            return;
        }
        int pos = size & (~ (row | ld | rd));
        while(pos != 0){
            int p = pos & (-pos);
            pos -= p;
            solve(row | p,(ld | p) << 1,(rd |p)>>1);
        }
    }
    public static void main(String[] args){
        Solution sn = new Solution();
        int result = sn.totalNQueens(4);
        System.out.println(result);
    }
}