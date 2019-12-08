import java.util.*;
/**
 *位1的个数
 */
class Solution {

    public int hammingWeight(int n) {
        int index = 32;
        int count = (n & 1) == 1 ? 1 : 0;
        while (index-- >= 0) {
            if (((n = n >> 1) & 1) == 1) count++;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1); //将最低位的 1 变为 0，所以能变多少个，就有多少个 1
            count++;
        }
        return count;
    }
}