import java.util.Arrays;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-27 07:35
 **/

public class Leetcode_338_371 {
    public static void main(String[] args) {
        int[] res = countBits2(5);
        Arrays.stream(res).forEach(System.out::println);

    }

    /**
     * 仿解1:位运算(利用 n&(n-1) 将每一个1清零)
     *
     * @author Shaobo.Qian
     * @date 2019/11/27
     * @link https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
     */
    public static int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = popCount(i);
            res[i] = count;
        }
        return res;
    }

    private static int popCount(int i) {
        int count = 0;
        while (i != 0) {
            count++;
            i &= i - 1;
        }
        return count;
    }

    /**
     * 仿解2:位运算+dp(自顶向下)
     *
     * @author Shaobo.Qian
     * @date 2019/11/27
     * @link https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
     */
    public static int[] countBits2(int num) {
        //a(n) = a(n >> 1) (偶数)
        //a(n) = a(n >> 1) + 1(奇数)

        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

}
