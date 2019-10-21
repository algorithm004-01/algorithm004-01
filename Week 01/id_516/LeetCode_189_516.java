//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 思路
 * 1. 开个新数组
 * 2. 环状替换
 * 3. 反转
 * <p>
 * 三个时间复杂度都是O(n)
 * 但第一个由于开了新的数组会相对占用更多空间 额外空间O(n)
 */
class Solution {

    /**
     * 思路1 开辟新数组
     *
     * 1. calculate min movement
     * 2. new same length array
     * 3. copy the content to new array where exactly it should be
     * 4. copy all new array content back to nums
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        // min movement
        k = k % nums.length;
        // store new array
        int[] tmpArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // i + k may exceed nums.length
            tmpArr[(i + k) % nums.length] = nums[i];
        }
        // copy back to nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmpArr[i];
        }
    }

    /**
     * 思路2 环状替换
     *
     * 1. 计算最小移动量 k
     * 2. 环装替换内容到对应的位置(暂存被替代的内容)
     *      2.1 循环位置如
     *            0, 0 + k, 0 + 2k ...
     *            1, 1 + k, 1 + 2k ...
     *            2, 2 + k, 2 + 2k ...
     *            ...
     *            n, n + k, n + 2k ...
     *
     *      2.2 环状替换 (计数器在这里做增加)
     *           nums[0 + k] -> formerValue;
     *           nums[0] -> [0 + k];
     *           ...
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        // min movement
        k = k % nums.length;
        int count = 0;
        for (int n = 0; count < nums.length; n++) {
            int curr = n;
            // 用以记录前一个的值
            int formerValue = nums[curr];
            do {
                int next = (curr + k) % nums.length;
                // 交换 formerValue ， num[next]
                int tmp = nums[next];
                nums[next] = formerValue;
                formerValue = tmp;
                curr = next;
                count++;
            }while (n != curr);
        }
    }


    /**
     * 思路3 反转
     *
     * 基于事实情况进行的算法
     *  1,2,3,4,5,6    2
     *  6,5,4,3,2,1
     *  5,6,4,3,2,1
     *  5,6,1,2,3,4
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 交换功能
     * @param nums 数组
     * @param startIndex 传入想要交换的前索引
     * @param endIndex 传入想要交换的后索引
     */
    public static void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            // exchange
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
