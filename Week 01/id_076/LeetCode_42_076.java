/**
 * 采用双指针方法，此题没什么思路
 * 只考虑使用双指针进行增加或减少
 * 看了leetCode 题解，基础不好需要多刷题
 *
 * @author tangzhenhua
 * @date 2019/10/20 20:15
 */
public class LeetCode_42_076 {

    public static int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int ans = 0;

        int leftMax = 0;
        int rightMax = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                ++left;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                --right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int size = trap(height);
        System.out.println(size);
    }

}