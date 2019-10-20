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

