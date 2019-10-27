//使用单调递增栈，即栈中的元素是从小到大递增的，但是此问题入栈的是元素的下标，即按照下标对应的元素是单调递增的
//该问题主要关注的点是，如果想以第 i 个元素的高度为矩形的高度，那么height[i]应该是跟它一起构成矩形所有矩形条中最小的，
//于是需要找满足这个条件的相对于 i 的左边界和右边界
//左边界和右边界的距离就是矩形的宽，跟高度的积就是矩形的面积
//遍历元素，如果在遍历过程中当前元素比栈顶元素大，说明栈顶元素的右边界还没有找到，于是将其入栈
//如果在遍历过程中当前元素比栈顶元素小，那说明以栈顶元素对应高度做矩阵的高的情况的右边界已经找到
//然后对应元素的左边界就是栈顶元素的下一个元素，因为栈是单调递增栈，故栈顶元素出出栈后的新的栈顶元素即为左边界
//在遍历过程中使用临时变量 maxArea 记录最大面积
//时间复杂度：O(n)
//空间复杂度：O(n)
//参考链接：https://www.cnblogs.com/boring09/p/4231906.html

public class Solution {
    public int largestRectangleArea(int[] height) {
        
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        int[] heights = Arrays.copyOf(height, height.length+1);
        heights[height.length] = -1;
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                if(stack.size() == 1){
                    maxArea = Math.max(maxArea,heights[stack.pop()]*i);
                }else{
                    int index = stack.peek();
                    maxArea = Math.max(maxArea,heights[stack.peek()]*(i-stack.pop()+index-stack.peek()-1));
                }
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }
}