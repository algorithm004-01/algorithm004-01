// 旋转数组
//
// 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
// 输出: [5,6,7,1,2,3,4]
// 解释:
// 向右旋转 1 步: [7,1,2,3,4,5,6]
// 向右旋转 2 步: [6,7,1,2,3,4,5]
// 向右旋转 3 步: [5,6,7,1,2,3,4]
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
// 输出: [3,99,-1,-100]
// 解释:
// 向右旋转 1 步: [99,-1,-100,3]
// 向右旋转 2 步: [3,99,-1,-100]
// 说明:
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/rotate-array
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

// 这道题用了两种方法求解, 第一种解法用了 24ms, 第二种解法用了 32ms

// 解法 1: 循环交换
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        // 计算等价的 k 值
        k = k % nums.size();
        int count = 0;
        if (nums.size() == 0 || k == 0) return;
        int j = 0;

        // 有时候环状交换会形成 loop, 无法遍历整个数组, 此时将起点递增迭代即可, 直到全部元素被替换成功
        while (count < nums.size()) {
            loop_rotate(nums, j, k, count);
            j++;
        }
    }

    void loop_rotate(vector<int> &nums, int start_index, int k, int &count) {
        int i = start_index;
        int mem = nums[i];
        while (true) {
            // 计算最终的位置
            int final_index = (i + k) % nums.size();

            // 交换 mem 和 nums[final_index]
            int mem_temp = nums[final_index];
            nums[final_index] = mem;
            mem = mem_temp;

            count++;
            i = final_index;
            if (i == start_index) break;
        }
    }
};

// 解法 2: 交换法
class SolutionV2 {
public:
    void rotate(vector<int>& nums, int k) {
        // 计算等价的 k 值
        k = k % nums.size();
        if (nums.size() == 0 || k == 0) return;

        reverse(nums, 0, nums.size()-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.size()-1);
    }

    void reverse(vector<int> &nums, int start_index, int end_index) {
        if (start_index == end_index) return;

        for (int i = start_index, j = end_index; i < j; ) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++, j--;
        }
    }
};

