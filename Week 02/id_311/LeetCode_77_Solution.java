//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private LinkedList<Integer> list = new LinkedList<Integer>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        backtrack(1, n, k);
        return result;
    }

    private void backtrack(int index, int n, int k) {
        if (list.size() == k) {
            result.add(new LinkedList(list));
            return;
        }
        for (int i = index; i < n + 1; i++) {
            list.add(i);
            backtrack(i + 1, n, k);
            list.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
