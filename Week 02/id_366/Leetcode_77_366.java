/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList(), 1, n, k);
        return res;
    }
    public void helper(List<List<Integer>> res, ArrayList<Integer> list, int index, int n, int k) {
        if(list.size() == k){
           res.add(new ArrayList(list)); 
        }

        for(int i = index; i <= n; ++i){
            list.add(i);
            helper(res, list, i+1, n, k);
            list.remove(list.size()-1);
        }
    }
}
// @lc code=end

