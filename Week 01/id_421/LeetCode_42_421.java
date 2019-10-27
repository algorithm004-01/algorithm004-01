import java.util.*;

/**
 * 接雨水问题(共三个实现方法)
 */
public class Solution {

    //初始版本(自己写出来的，没看任何提示，所以代码有点凌乱) 4ms
    public static int trap(int[] height) {
        LinkedList<Integer> queue = new LinkedList<>();
        int left = 0;
        int q = 0;
        queue.push(left);
        for (int i = 1; i < height.length; i++) {
            if (height[left] <= height[i]) {
                if (left + 1 == i) {
                    queue.pollFirst();
                } else {
                    int inner = 0;
                    for (int j = left; j <= i - 1; j++) {
                        inner += height[j];
                        queue.pollFirst();
                    }
                    q += height[left] * (i - left) - inner;
                }
                left = i;
            }
            queue.push(i);
            int side = left;
            if (i == height.length - 1 && !queue.isEmpty()) {
                int inner = -1;
                int right = 0;
                for (int k = height.length - 1; k >= side; k--) {
                    if (right == 0 && k > 0 && height[k] <= height[k - 1])
                        queue.pollLast();
                    else {
                        if (right == 0) {
                            right = k;
                        } else {
                            if (height[k] < height[right]) {
                                if (inner == -1)
                                    inner = 0;
                                inner += height[k];
                                left = k;
                            } else {
                                if (inner != -1) {
                                    q += height[right] * (right - left + 1) - inner - height[right];
                                    inner = 0;
                                    right = 0;
                                    k += 1;
                                }
                            }
                        }
                        queue.pollLast();
                    }
                }
            }

        }
        return q;
    }

    //查看解析后改进版
    public static int trap2(int[] height) {
        int sum = 0;
        int min_left = 0;
        int min_right = height.length - 1;
        for (int left = 1, right = height.length - 2; left <= right; ) {
            if (height[min_left] <= height[min_right]) {
                if (height[min_left] < height[left]) {
                    min_left = left;
                } else
                    sum += height[min_left] - height[left];
                left += 1;
            } else {
                if (height[min_right] < height[right]) {
                    min_right = right;
                } else {
                    sum += height[min_right] - height[right];
                }
                right -= 1;
            }
        }
        return sum;
    }

    //缩短行数最终版
    public static int trap3(int[] height) {
        if (height.length == 0) return 0;
        int sum = 0;
        int min_left = height[0];
        int min_right = height[height.length - 1];
        for (int left = 1, right = height.length - 2; left <= right; ) {
            if (min_left <= min_right) {
                min_left = Math.max(min_left, height[left]);
                sum += min_left - height[left++];
            } else {
                min_right = Math.max(min_right, height[right]);
                sum += min_right - height[right--];
            }
        }
        return sum;
    }
}
