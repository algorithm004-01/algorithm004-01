import java.util.*;
/**
 * 比特位计数
 */
class Solution {
    /**
     * 比特位计数
     * 傻循环
     */
    public int[] countBits(int num) {
        int[] arr = new int[num + 1];
        arr[0] = 0;
        for (int i = 1; i <= num; i++) {
            int count = 0;
            int n = i;
            while (n != 0) {
                count++;
                n = n & (n - 1);
            }
            arr[i] = count;
        }
        return arr;
    }

    /**
     * 比特位计数
     * 最后一位置零，在加 1，
     */
    public int[] countBits2(int num) {
        int arr[] = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            arr[i] = arr[i & (i - 1)] + 1;
        }
        return arr;
    }

    /**
     * 比特位计数
     * 右移一位，在加上其奇偶性
     */
    public int[] countBits3(int num) {
        int arr[] = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            arr[i] = arr[i >> 1] + (i & 1);
        }
        return arr;
    }
}