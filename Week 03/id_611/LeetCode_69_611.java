/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {

    public int mySqrt(int x){
        long n = x;
        while(n *n > x){
            n = (n + x/n)/2;
        }
        return (int)n;
    }

    //????
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        long left = 1;
        long right = x/2 +1;
        while(left < right){
            long mid = (left + right + 1) >>> 1;
            long sq = mid * mid;
            if(sq > x){
                right = mid -1;
            }else{
                left = mid;
            }
        }
        return (int)left;
    }
}
// @lc code=end

