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


package leetcode.editor.cn;

import java.util.Stack;

//Java：接雨水
//第一周
public class P42TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        // TO TEST
        //解法1.其实就是求低和高的问题，低恒等于1,然后本题则演变成求高的问题 ,时间复杂度 0(n)
        //解法2.将每个位置i的面积累加，该位置i是否有面积，则根据他的左右邻高度确定,时间复杂度 0(n)
                //这个思路进一步优化，可以考虑为，i节点的左右最近哥哥(比i高的为哥哥)高的问题

//        int[] aa =  new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] aa =  new int[]{2,1,0,2};
        System.out.println(solution.trap(aa));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
//        Stack<Integer> stack = new Stack();
//        stack.push(height[0]);
        //[0,1,0,2,1,0,1,3,2,1,2,1]
        //[2,1,0,2]
        //[4,2,3]
        int maxLeft = 0,maxRight = 0,minHeight = 0;
        int area = 0;
        int length =  height.length;
        if (length == 0){
            return 0;
        }
        maxRight = maxRight(0,height);;
        for (int i = 1; i < length - 1; i++) {
            if (maxRight <= i){
                maxRight = maxRight(i,height);
            }
            maxLeft = maxLeft(i,height);
            minHeight = Math.min(height[maxLeft],height[maxRight]);
            if (minHeight >= height[i]){
                area += minHeight -height[i];
            }
        }
        return area;
    }


    private int maxRight(int index,int[] height){
        int maxValue = 0;
        int maxIndex = 0;
        for (int i = index+1; i < height.length; i++) {
            if (i < height.length && maxValue <= height[i] ){
                maxValue = height[i];
                maxIndex= i;
            }
        }
        return maxIndex;
    }

    private int maxLeft(int index,int[] height){
        int maxValue = 0;
        int maxIndex = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (i >= 0 && maxValue <= height[i] ){
                maxValue = height[i];
                maxIndex= i;
            }
        }
        return maxIndex;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}