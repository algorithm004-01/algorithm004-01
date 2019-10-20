// 基本解法，按照题目的描述，从0开始的遍历数组。由于数组是有序的，如果存在重复应该会连续出现。
// 从0开始遍历数组，使用双指针i和j，i从0开始，j初始值为i+1，不停向后寻找第一个出现的与i的位置不同的第一个元素，然后j所在位置的元素赋值给i+1，然后i自增1，直到j遍历到数组结束。数组的新长度即为i+1

//class Solution {
//    public int removeDuplicates(int[] nums) {
//        if (nums.length <= 1) { // 处理特殊情况
//            return nums.length;
//        }
//
//        int i = 0, j = 1;
//        while (j<nums.length) {
//            if (nums[j] != nums[i]) {
//                nums[i+1] = nums[j];
//                i++;
//            }
//            j++;
//        }
//
//        return i + 1;
//    }
//}

// 从leetcode讨论里面看到的解法二：
// 遍历数组，使用一个变量count来记录重复元素个数，因为是有序数组，所以判断相邻的两个元素就可以了，遇到不重复的只需要将值赋值给第i-count位置即可
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                count ++;
            } else {
                nums[i-count] = nums[i];
            }
        }

        return nums.length - count;
    }
}