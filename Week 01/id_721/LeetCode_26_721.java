package array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路：
 * 1. 遍历有序数组，用一个指针标记k标记k前面的数字都已去重；当遍历标记i遍历的时候，与前一位比较是否相等，如果相等，则k移动到当前
 * <p>
 *
 * @author alis
 * @date 2019/10/20 3:03 PM
 * @description
 */
public class LC_26_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] sortNums) {
        int k = 0;
        for (int i = 1; i < sortNums.length; i++) {
            if (sortNums[i] != sortNums[i - 1]) {
                sortNums[++k] = sortNums[i];
            }

        }
        return k + 1;


    }
}
