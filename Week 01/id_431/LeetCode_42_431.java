package hard;

/**
 * 这道暂时还没理解。。。
 * @author 潘磊明
 * @date 2019/10/20
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) return 0;

        int ans = 0;
        int l = 0, r = height.length - 1;

        while (l < r && height[l] <= height[l + 1]) l++;
        while (l < r && height[r] <= height[r - 1]) r--;

        while (l < r) {
            int left = height[l];
            int right = height[r];
            if (left <= right) {
                while (l < r && left >= height[++l]) {
                    ans += left - height[l];
                }
            } else {
                while (l < r && height[--r] <= right) {
                    ans += right - height[r];
                }
            }
        }
        return ans;
    }
}
