ppackage com.five;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 */
public class ClimbStairs {

    //1.暴力法先找到规律
    //  n=1的时候可以有1中方法.
    //  n=2的时候可以有：1+1/2，2种方法。
    //  n=3的时候可以有1+1+1/1+2/2+1，3种方法.
    //  n=4的时候可以有1+1+1+1/1+2+1/2+1+1/1+1+2/2+2,5种方法.
    //  n=5的时候可以有1+1+1+1+1/1+1+1+2/1+1+2+1/1+2+1+1/2+1+1+1/2+2+1/2+1+2/1+2+2/,8中方法.
    //  .........
    //  n=n的时候，F(n) = F(n-1) + F(n-2)
    //

    //1.reverse的方法，递归的方式时间复杂度是：O(2^n)，不建议使用
    public int climbStairsNum(int n){
        if(n<=2)return n;
        return climbStairsNum(n-1)+climbStairsNum(n-2);
    }

    //2.找重复性，找最新的 子重复性，然后泛华，找到共同点。loop的方法,时间复杂度为O（n）
    public int climbStairs(int n) {
        if(n<=2) {
            return n;
        }
        int prev = 1;
        int next = 2;
        int nums = 0;
        for (int i = 2; i < n; i++) {
            nums = prev+next;
            prev = next;
            next = nums;
        }
        return nums;
    }

}
