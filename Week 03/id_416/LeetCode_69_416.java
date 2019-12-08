/**
 实现 int sqrt(int x) 函数。

 计算并返回 x 的平方根，其中 x 是非负整数。

 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

 示例 1:

 输入: 4
 输出: 2
 示例 2:

 输入: 8
 输出: 2
 说明: 8 的平方根是 2.82842...,
      由于返回类型是整数，小数部分将被舍去。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sqrtx
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_22_416{
    //1、3、4、7、9、33
    public int mySqrt(int x) {
        long left = 0;
        long right = x/2 + 1;
        while(left < right) {
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if(square > x) {
                right = mid - 1;
            } else {
                left = mid ;
            }
        }
        return (int)left;
    }
}