import java.util.*;
/**
 * 数组的相对排序
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] times = new int[1001], res = new int[arr1.length];
        for (int value : arr1)
            times[value]++;
        int index = 0;
        for (int value : arr2)
            while (times[value]-- > 0)
                res[index++] = value;
        for (int i = 0; i <= 1000; i++)
            while (times[i]-- > 0)
                res[index++] = i;
        return res;
    }
}