package Week1;

import java.util.Stack;

public class Leetcode_042 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }




    /**
     * 两遍扫描方法，找到index位置左边的最大高度和右边的最大高度
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :37.2 MB, 在所有 java 提交中击败了84.69%的用户
     * @param height
     * @return
     */
    private static int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 1; i < len - 1; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }

    /**
     * 双指针解法
     * 巧妙。。。想不出来
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :37.7 MB, 在所有 java 提交中击败了82.55%的用户
     */
    private static int trap1(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right){
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                }
                else {
                    ans += leftMax - height[left];
                }
                left++;
            }
            else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                }
                else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }

//    /**
//     * 栈解法，暂时错误
//     */
//    private static int trap2(int[] height) {
//        Stack<Integer> stack = new Stack<>();
//        int ans = 0, current = 0;
//        while (current < height.length){
//            while (!stack.isEmpty() && height[current] > stack.peek()) {
//                int top = stack.pop();
//                if (stack.isEmpty())
//                    break;
//                int distance = current - stack.pop() - 1;
//                int boundHeight = Math.min(height[current], height[stack.pop()] - height[top]);
//                ans += distance * boundHeight;
//            }
//            stack.push(current++);
//        }
//        return ans;
//    }

}
