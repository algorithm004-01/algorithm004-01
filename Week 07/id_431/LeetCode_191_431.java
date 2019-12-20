package easy;

/**
 * @author 潘磊明
 * @date 2019/11/29
 */
public class NumberOf1Bits {
    /**
     * 使用掩码
     * @param n
     * @return
     */
//    public int hammingWeight(int n) {
//        int count = 0;
//        int mask = 1;
//        for (int i = 0; i < 32; i++) {
//            if ((n & mask) != 0) count++;
//            mask <<= 1;
//        }
//        return count;
//    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
