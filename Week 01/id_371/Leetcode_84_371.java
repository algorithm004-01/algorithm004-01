import java.util.Stack;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-10 16:08
 **/

public class Leetcode_84_371 {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int largeArea = largestRectangleArea2(heights);
        System.out.println("largeArea = " + largeArea);
    }

    /**
     * 仿解2:(单调递增栈:栈中保存bar 对应的索引,索引对应的 bar 高度单调递增,这样利用栈非常方便确定当前索引的 bar 往左右延伸最大面积时的边界)方便确定边界==>栈顶的上一元素就是左边界
     *
     * @author Shaobo.Qian
     * @date 2019/11/10
     */
    public static int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        //1.设置index=0的 bar 的左边界
        stack.push(-1);
        int maxArea = 0;
        //2.将所有元素压入栈
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));//i是右边界,栈顶的上一个元素:stack.peek()就是左边界
            }
            stack.push(i);
        }
        //3.减剩下栈中所有元素弹出
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() -1));//heights.length是右边界额额,栈顶的上一个元素:stack.peek()就是左边界
        }
        return maxArea;
    }

    /**
     * 仿解1:jump index
     *
     * @author Shaobo.Qian
     * @date 2019/11/10
     * @link https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhao-liang-bian-di-yi-ge-xiao-yu-ta-de-zhi-by-powc/
     * @link
     */
    public static int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int count = heights.length;//为 bar 的个数
        int[] lessFromLeft = new int[count];
        int[] lessFromRight = new int[count];
        //设置左右边界
        lessFromLeft[0] = -1; //lessFromLeft[0]即,在第一个bar的位置(currentIndex=0),指针往左出现的第一个比 currentIndex 对应 bar 的高度 矮的 bar 对应的索引,因为 currentIndex = 0对应的为一个 bar,比它还矮的没有了,所以设置为-1(设置为-1符合后面计算rectangle 长度的公式)
        lessFromRight[count - 1] = count; //和上面的解释同理

        for (int currIndex = 1; currIndex < count; currIndex++) {
            int preIndex = currIndex - 1;
            while (preIndex >= 0 && heights[preIndex] >= heights[currIndex]) {
                preIndex = lessFromLeft[preIndex];//lessFromLeft[preIndex]指向的是从当前位置指针向左,第一次出现的比currIndex-1索引对应 bar 高度矮的 bar 对应的索引,索引将它赋值给 preIndex,从而实现  jump index,而不需要将 currIndex 之前的每一个 bar 的高度来和当前 bar 高度比较
            }
            lessFromLeft[currIndex] = preIndex;
        }

        for (int currIndex = count - 2; currIndex >= 0; currIndex--) {
            int nextIndex = currIndex + 1;
            while (nextIndex < count && heights[nextIndex] >= heights[currIndex]) {
                nextIndex = lessFromRight[nextIndex];
            }
            lessFromRight[currIndex] = nextIndex;
        }

        //找到每个索引位置向左右延伸能达到的最大面积,依次比较,每次保存更大的
        int maxArea = 0;
        for (int i = 0; i < count; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return maxArea;
    }
}
