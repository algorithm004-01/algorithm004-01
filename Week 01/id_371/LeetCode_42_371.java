/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-20 10:52
 **/

public class LeetCode_42_371 {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(height);
        System.out.println("trap = " + trap);
    }

    /**
     * 暴力法(背向双指针)
     *
     * @return
     * @思路: 每个宽度为1的区间能接水面积=(向左的最大高度和向右的最大高度中取较小值-当前区间的高度),将所有区间接水量相加,即总接水量
     */
    public static int trap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            //从当前索引位置向左扫描
            for (int j = i; j > 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            //从当前索引位置向右扫描
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            ans += Math.min(leftMax, rightMax) - height[i];
        }
        return ans;
    }

    /**
     * 针对暴力法的优化
     *
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        //leftMax一直是向左边比较,所以先确定leftMax[0],往右遍历时每次只需要比较依次就能确定当前位置的 leftMax ==>rightMax的确定正好相反
        leftMax[0] = height[0];
        //用数组记录下每个位置的 leftMax
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        //用数组记录下每个位置的 rightMax
        for (int i = 0; i < size; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }


}
