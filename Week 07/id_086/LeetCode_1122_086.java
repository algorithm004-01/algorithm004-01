/**
 *  1122.数组的相对排序
 */

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        for (int num : arr1) {
            bucket[num]++;
        }
        int i = 0;
        for (int num:arr2) {
            while (bucket[num] -- > 0) {
                arr1[i++] = num;
            }
        }
        for (int j = 0; j < 1001; j++) {
            while (bucket[j]-- > 0) {
                arr1[i++] = j;
            }
        }
        return arr1;
    }
}