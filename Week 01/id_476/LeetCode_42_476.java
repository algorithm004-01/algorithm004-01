//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针

package com.markdown.leetcode.editor.cn;

import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    // class Solution {
    //     public int trap(int[] height) {
    //
    //         int total = 0;
    //         for (int i = 1; i < height.length - 1; i++) {
    //             int maxLeft = 0, maxRight = 0;
    //             for (int j = 0; j <= i; j++) {
    //                 maxLeft = Math.max(maxLeft, height[j]);
    //             }
    //             for (int k = i; k < height.length; k++) {
    //                 maxRight = Math.max(maxRight, height[k]);
    //             }
    //             total += Math.min(maxLeft, maxRight) - height[i];
    //         }
    //         return total;
    //     }
    // }

    class Solution {
        public int trap(int[] height) {

            int total = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    Integer pop = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    int h = height[pop];
                    int dist = i - stack.peek() - 1;
                    int min = Math.min(height[stack.peek()], height[i]);
                    total += (min - h) * dist;
                }
                stack.push(i);
            }
            return total;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}