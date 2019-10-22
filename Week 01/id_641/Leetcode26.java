package vip.ruoyun;

import java.util.ArrayList;
import java.util.List;

//26
public class Leetcode26 {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(1);
        integerList.add(2);
        Solution solution = new Solution();
//        solution.removeDuplicates(integerList);

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length = solution.removeDuplicates(nums);

        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }

    }
}


class Solution {
    public int removeDuplicates(List<Integer> nums) {
        //返回值为长度
        //额外空间 O(1)
        //1.遍历数组
        int num;
        for (int i = 0; i < nums.size(); i++) {
            //暴力,保存 每一份,然后遍历 删除
            System.out.println(nums.get(i));
            num = nums.get(i);
            for (int j = i + 1; j < nums.size(); j++) {
                System.out.println(nums.get(j));
                if (num == nums.get(j)) {
                    //删除多余的元素
                    nums.remove(j);
                }
            }
        }
        System.out.println(nums.toString());
        return nums.size();
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                if (j - i > 0) {//优化
                    i++;
                    nums[i] = nums[j];
                }
            }
        }
        return i + 1;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                if (j - i > 0) {//优化
                    i++;
                    nums[i] = nums[j];
                }
            }
            j++;
        }
        return i + 1;
    }


}

//遇到问题
//1.怎么删除 int[] 中的元素,所以使用了 java 中的 list
//2.如果不经过 2 重循环的话,怎么找到重复元素
//3.题目给出 是排好序的数组,所以在查找重复元素的时候,只要找前一个和后一个数的值 是否相等,就可以判断是否重复

//
//java 中的标记清除算法,可以减少删除元素后,数组移动的次数,来达到优化的效果
//O(n) 复杂度