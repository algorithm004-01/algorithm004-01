package homework.week07;

/**
 * 1122. 数组的相对排序
 * https://leetcode-cn.com/problems/relative-sort-array/
 * @author tangxy
 * @date 2019-12-01
 */
public class LeetCode_1122_501 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1001];
        for (int i : arr1) {
            arr[i]++;
        }
        int index = 0;
        for (int i : arr2) {
            while(arr[i] > 0){
                arr1[index ++] = i;
                arr[i] --;
            }
        }
        for(int i = 0;i<1001;i++){
            while (arr[i] > 0){
                arr1[index++] = i;
                arr[i]--;
            }
        }
        return arr1;
    }
}
