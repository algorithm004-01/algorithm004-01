//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例:
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private LinkedList<Integer> list = new LinkedList<Integer>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        backtrack(0, nums, visited);
        return result;
    }

    private void backtrack(int index, int[] nums, int[] visited) {
        if (index == nums.length) {
            result.add(new LinkedList(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] != 1) {
                if (i > 0 && (nums[i] == nums[i - 1]) && (visited[i - 1] != 1)) {
                    continue;
                }
                visited[i] = 1;
                list.add(nums[i]);
                backtrack(index +1 , nums, visited);
                list.removeLast();
                visited[i] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
