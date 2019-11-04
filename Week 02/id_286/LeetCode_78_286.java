package com.uanei;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_78_286 {

    /**
     * 分治递归
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        dfs(res, nums, new ArrayList<Integer>(), 0);
        return res;
    }

    /**
     * 解题思路：
     * 1 每个元素选或者不选两种结果
     * 2 元素的索引就是递归的层级
     *
     * @param res   结果
     * @param nums  数组
     * @param list  子集
     * @param index 层级
     */
    private void dfs(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, int index) {
        // terminator
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        // process
        // 当前元素不选
        // // drill down
        dfs(res, nums, list, index + 1);

        list.add(nums[index]);

        // 加入当前元素
        dfs(res, nums, list, index + 1);

        // reverse state
        // 因为list是有状态的，不是局部变量，需要清除当前元素
        list.remove(list.size() - 1);
    }

}
