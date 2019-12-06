//给你一个数组，里面有一个数字出现的次数超过了一半，你要找到这个数字并返回
// 遍历整个数组，统计数组中每一个数字出现的次数，将出现次数大于一半的元素输出

class Solution {
    public int majorityElement(int[] nums) {
        int mid = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int num1 : nums) {
                if (num1 == num) {
                    count++;
                }
            }
            if (count > mid) {
                return num;
            }
        }
        return -1;
    }
}