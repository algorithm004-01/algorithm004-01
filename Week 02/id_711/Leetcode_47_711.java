package Week2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_47 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> list = solution(nums);
        System.out.println(list);
    }

    /**
     * 几月前写法
     * 执行用时 :73 ms, 在所有 java 提交中击败了22.46%的用户
     * 内存消耗 :53 MB, 在所有 java 提交中击败了14.55%的用户
     * @param nums
     * @return
     */
    private static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        qpl(list,ll,flag,nums,0);
        return removeDuplicate(list);
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

    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }
}
