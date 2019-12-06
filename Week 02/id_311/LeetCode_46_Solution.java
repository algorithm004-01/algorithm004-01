//给定一个没有重复数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private List<Integer> list = new ArrayList<Integer>();

    public List<List<Integer>> permute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        backtrack(nums.length, 0);
        return result;
    }

    private void backtrack(int n, int index) {
        if (n == index) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = index; i < n; i++) {
            Collections.swap(list, index, i);
            backtrack(n, index + 1);
            Collections.swap(list, index, i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
