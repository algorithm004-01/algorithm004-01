
// package io.github.shniu.arts.training.week01;

public class LeetCode_283_716 {

    // 1 计数法
    public void moveZeroes11(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int zeroCnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] ==  0) {
                zeroCnt++;
            } else {
                // 这里减少无谓的赋值操作
                if (i - zeroCnt != i) {
                    nums[i - zeroCnt] = nums[i];
                }
            }
        }

        // 填充0
        for (int i = nums.length - zeroCnt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 1.2
    public void moveZeroes12(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int zeroCnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] ==  0) {
                zeroCnt++;
            } else {
                // 这里减少无谓的赋值操作
                if (i - zeroCnt != i) {
                    nums[i - zeroCnt] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }

    // 1.3, another snowball implementation
    public void moveZeroes13(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int snowballSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowballSize++;
            } else if (snowballSize > 0) {
                nums[i - snowballSize] = nums[i];
                nums[i] = 0;
            }
        }
    }

    // 2 双指针法
    // 2.1
    public void moveZeroes21(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        // 慢指针，跟踪可插入的非0元素的位置
        int nonZeroInsertPos = 0;

        for (int i = 0; i < nums.length; i++) {
            // i 是快指针，寻找非0元素
            if (nums[i] != 0) {
                nums[nonZeroInsertPos++] = nums[i];
            }
        }

        while (nonZeroInsertPos < nums.length) {
            nums[nonZeroInsertPos++] = 0;
        }
    }

    // 2.2，和 2.1 非常相似的写法
    public void moveZeroes22(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int nonZeroInsertPos = 0;

        for (int num : nums){
            if (num != 0) nums[nonZeroInsertPos++] = num;
        }

        while (nonZeroInsertPos < nums.length) {
            nums[nonZeroInsertPos++] = 0;
        }
    }

    // 2.3
    public void moveZeroes23(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int nonZeroInsertPos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 优化：只是在这里加了一个判断，少做一些无用的赋值操作
                if (nonZeroInsertPos != i) {
                    nums[nonZeroInsertPos] = nums[i];
                    // 优化：直接将移动之后的位置归0，省去了最后再补0的循环操作
                    nums[i] = 0;
                }
                nonZeroInsertPos++;
            }
        }
    }

    // 3. 新数组copy的方法，这个不符合题目要求，实现如下
    public void moveZeroes3(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int[] tmpArr = new int[nums.length];
        int j = 0;

        for (int num : nums) {
            // copy 非0
            if (num != 0) {
                tmpArr[j++] = num;
            }
        }

        // copy 回来
        for (int i = 0; i < nums.length; i++) {
            if (i < j) {
                nums[i] = tmpArr[i];
            } else {
                nums[i] = 0;
            }
        }
    }

}

