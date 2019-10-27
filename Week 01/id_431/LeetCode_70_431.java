package simple;

/**
 * @author 潘磊明
 * @date 2019/10/18
 */
public class ClimbingStairs {
    /**
     * 使用递归思想解决问题
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        } else {
            //设置两个变量记录缓存值
            int prev = 1;
            int cur = 2;
            for(int i = 3; i < n; i++) {
                int tmp = prev + cur;
                prev = cur;
                cur = tmp;
            }
            return prev + cur;
        }
    }
}
