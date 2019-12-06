package bit;

/**
 * @author alis
 * @date 2019/12/1 8:12 AM
 * @description
 */
public class LeetCode_191_721 {
    /**
     * 题意
     * 计算输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数(汉明重量)
     * 思路：
     * 1. for loop ，遍历计算法 (32)
     * 2. %2 /2 取出最后一个，判断是否为1 (32)
     * 3. n & 1 看最低位是0 还是1， 每次 x = x >> 1向右移一位，进行下一次判断 (32)
     * 4. x = x & (x-1) 清0最低位的1(将最后一个1变为0) 判断x是否位0； while (x != 0) {count++; x = x & (x -1);}
     */
    public int hammingWeightRemoveLastOne(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1); //将最后一个1位移除，计算移除了多少个1位，就可以得到结果
        }
        return count;
    }

    /**
     * 移除最后一位，判断最后一位是否是1，再进行统计
     */
    public int hammingWeightRemoveLastIndex(int n) {
        int count = 0;
        while (n != 0) { // 退出条件，移除最后一位，直至这个整数的所有数位都已经被移除 --> 0
            int last = n & 1;
            if (last == 1) count++;
            n = n >> 1; // 右移动一位，取出最后一位
        }
        return count;
    }

    public int hammingWeightMod(int n) {
        int count = 0;
        while (n != 0) {
            int cur = n % 2;
            if (cur == 1) count++;
            n = n / 2;
        }
        return count;
    }
}
