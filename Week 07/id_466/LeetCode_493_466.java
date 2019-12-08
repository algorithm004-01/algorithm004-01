//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
//
// 你需要返回给定数组中的重要翻转对的数量。
//
// 示例 1:
//
//
//输入: [1,3,2,3,1]
//输出: 2
//
//
// 示例 2:
//
//
//输入: [2,4,3,5,1]
//输出: 3
//
//
// 注意:
//
//
// 给定数组的长度不会超过50000。
// 输入数组中的所有数字都在32位整数的表示范围内。
//
// Related Topics 排序 树状数组 线段树 二分查找 分治算法
package com.aseara.leetcode.editor.cn.a493;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 493.翻转对 <br />
 * Date: 2019/11/28 <br/>
 *
 * @author qiujingde
 */
class ReversePairs {
    private Solution solution = new Solution();

    @Test
    void test1() {
        int[] test1 = {1,3,2,3,1};
        assertEquals(2, solution.reversePairs(test1));

        int[] test2 = {2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647};
        assertEquals(9, solution.reversePairs(test2));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return method2(nums);
    }

    private int merge(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) >> 1;
        int cnt = merge(nums, l, mid);
        cnt += merge(nums,mid + 1, r);

        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1;
        int k = 0;

        int n = mid + 1;
        for (int m = l; m <= mid; m++) {
            for (; n <= r; n++) {
                if (nums[m] > 2L * nums[n]) {
                    cnt += mid - m + 1;
                } else {
                    break;
                }
            }
        }

        while (i <= mid && j <= r) {
            tmp[k++] = nums[i] > nums[j] ? nums[j++] : nums[i++];
        }
        if (i <= mid) {
            System.arraycopy(nums, i, tmp, k, mid - i + 1);
        }
        if (j <= r) {
            System.arraycopy(nums, j, tmp, k, r - j + 1);
        }
        System.arraycopy(tmp, 0, nums, l, tmp.length);
        return cnt;
    }

    private int method2(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        BinaryIndexedTree bit = new BinaryIndexedTree(nums.length);
        int cnt = 0;

        for (int i = nums.length - 1; i > 0; i--) {
            int num = nums[i];
            cnt += bit.query(lowBound(copy, (num >> 1) - (~num & 1)));
            bit.update(lowBound(copy, num), 1);
        }

        return cnt;
    }

    private int lowBound(int[] list, long num) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] >= num) {
                return i;
            }
        }
        return list.length;
    }

}

class BinaryIndexedTree {
    private int[] bitArr;

    public BinaryIndexedTree(int n) {
        bitArr = new int[n + 1];
    }

    public BinaryIndexedTree(int[] list) {
        bitArr = new int[list.length + 1];
        System.arraycopy(list, 0, bitArr, 1, list.length);
        for (int i = 1; i < bitArr.length - 1; i++) {
            int j = i + (i & -i);
            if (j < bitArr.length) {
                bitArr[j] += bitArr[i];
            }
        }
    }

    public void update(int idx, int delta) {
        for (int i = idx + 1; i < bitArr.length; i += (i & -i)) {
            bitArr[i] += delta;
        }
    }

    public int query(int idx) {
        int result = 0;
        for (int i = idx + 1; i > 0; i -= (i & -i)) {
            result += bitArr[i];
        }
        return result;
    }

    public int range(int from, int to) {
        if (from > to) {
            return 0;
        }
        if (from == 0) {
            return query(to);
        }
        int and = (from - 1) & to;
        return query(to - and) - query(from - and - 1);
    }

    public int up(int idx) {
        return range(idx, bitArr.length - 2);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
