import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] h = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] h2 = new int[]{4, 2, 3};
        System.out.println(trap(h2));
        System.out.println(trap2(h2));
    }

    public static int trap(int[] height) {
        int result = 0;
        for (int i = 1; i <= height.length - 2; ++i) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; --j) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j <= height.length - 1; ++j) {
                max_right = Math.max(max_right, height[j]);
            }
            result += Math.min(max_left, max_right) - height[i];
        }
        return result;
    }

    public static int trap2(int[] height) {
        int result = 0, current = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = current - stack.peek() - 1;
                int minHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                result += distance * minHeight;
            }
            stack.push(current++);
        }
        return result;
    }
}
