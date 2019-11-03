package Week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = solution(nums);
        System.out.println(list);
    }

    /**
     * 几个月前写的
     *执行用时 :2 ms, 在所有 java 提交中击败了86.63%的用户
     * 内存消耗 :37.5 MB, 在所有 java 提交中击败了90.05%的用户
     * @param nums
     * @return
     */
    private static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        qpl(list,ll,flag,nums,0);
        return list;
    }

    private static void qpl(List<List<Integer>> list, List<Integer> ll, boolean[] flag, int[] nums, int x) {
        if (x == nums.length){
            list.add(new LinkedList<>(ll));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i])
                continue;
            flag[i] = true;
            ll.add(0,nums[i]);
            qpl(list,ll,flag,nums,x + 1);
            flag[i] = false;
            ll.remove(0);
        }
    }
}
