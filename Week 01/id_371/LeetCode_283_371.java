import java.util.Arrays;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-20 07:50
 **/

public class LeetCode_283_371 {
    public static void main(String[] args) {
        // 必须在原数组上操作，不能拷贝额外的数组。
        // 尽量减少操作次数。
        int[] nums = {0, 1, 0, 3, 12};//[1,3,12,0,0] 1,0,0,3,12 ==> 1,3,0,0,12
        moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void moveZeroes(int[] nums) {
        //一个指针当前为零的元素(将要被交换的元素),一个指针指向当前遍历到到的元素
        int needSwapIndex = -1;
        //等待被交换的0元素的个数,用来确定下一个被交换元素的索引
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (needSwapIndex < 0 && nums[i] == 0) {
                needSwapIndex = i;
                num++;
            } else if (needSwapIndex >= 0 && nums[i] != 0) {
                swap(nums, needSwapIndex, i);
                num--;
                if (i - needSwapIndex > 1 && num > 0) {
                    needSwapIndex = i;
                } else {
                    needSwapIndex++;
                }
            }
        }
    }

    public static void swap(int[] nums, int needSwapIndex, int i) {
        int temp = nums[i];
        nums[needSwapIndex] = nums[i];
        nums[i] = 0;

    }

    //todo:自己写一遍(理解清楚i - zeroCount确定待交换的0元素位置)
    public void moveZeroes1(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                if (zeroCount > 0) {
                    //i - zeroCount确定待交换的0元素位置
                    nums[i - zeroCount] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i != nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                // 防止[1], [1, 0]这种输入
                if (i != j) {
                    nums[i] = 0;
                }
                ++j;
            }
        }
    }

    public void moveZeroes3(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[j] == 0) {
                j--;
            }
            while (i < j && nums[i] != 0) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

        }
    }
}
