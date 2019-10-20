// 这道题我用了两种解法,
// 第一种是常规的 O(N) 解法, 耗时 24ms,
// 第二种略作优化, 设置一个 bool 变量, 记录数组中是否存在重复项, 只有存在重复项时才拷贝值, 耗时 20ms

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) return 0;

        int index_final = 0;

        for (int i = 1; i < nums.size(); i++) {
            // look back
            if (nums[i] == nums[i - 1])
                continue;
            index_final++;
            nums[index_final] = nums[i];
        }

        return index_final + 1;
    }
};

// 方法 2: 只有存在重复项才拷贝值, 节省了 4ms
class SolutionV2 {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) return 0;

        bool duplicated_exist = false;
        int index_final = 0;

        for (int i = 1; i < nums.size(); i++) {
            // look back
            if (nums[i] == nums[i - 1]) {
                if (!duplicated_exist)
                    duplicated_exist = true;
                continue;
            }
            index_final++;
            if (duplicated_exist)
                nums[index_final] = nums[i];
        }

        return index_final + 1;
    }
};
