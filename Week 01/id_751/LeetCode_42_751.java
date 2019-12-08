/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 */

class Solution {
    public int trap(int[] height) {
        int result = 0;

        //find the highest value/position
        int maxHigh = 0;
        int maxIdx = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHigh){
                maxHigh = height[i];
                maxIdx = i;
            }
        }

        //from the left to the highest postion
        int prevHigh = 0;
        for (int i = 0; i < maxIdx; i++) {
            if(height[i] > prevHigh){
                prevHigh = height[i];
            }
            result += (prevHigh - height[i]);
        }

        //from the right to the highest postion
        prevHigh=0;
        for (int i = height.length-1; i > maxIdx; i--) {
            if(height[i] > prevHigh) {
                prevHigh = height[i];
            }
            result += (prevHigh - height[i]);
        }

        return result;
    }
}