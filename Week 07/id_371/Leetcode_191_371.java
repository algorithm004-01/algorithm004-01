/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-26 18:33
 **/

public class Leetcode_191_371 {
    public static void main(String[] args) {

    }

    /**
     * 仿解1:位掩码
     * @author Shaobo.Qian
     * @date 2019/11/26
     * @link https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
     */
    public int hammingWeight(int n) {
        int bits = 0;//2进制中1的个数
        int mask = 1;//0000 0000 0000 0000 0000 0000 0000 0001
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }


    /**
     * 仿解2:位掩码
     * @author Shaobo.Qian
     * @date 2019/11/26
     * @link https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
     */
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }


}
