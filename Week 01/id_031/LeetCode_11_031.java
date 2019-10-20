package id_031;

/**
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xuhaojie created on 2019-10-20
 */
public class LeetCode_11_031 {
  // 1. 计算每一个面积并比较最大值
  // 2. 夹逼法

  /**
   * 计算每一个面积并比较最大值 双重循环，第一层从首位开始，第二层从第二位（第二位后一位）开始
   */
  public int maxArea(int[] height) {
    int maxArea = 0;
    // i < height.length - 1 保证 i 与 j 不相遇
    // int j = i + 1 保证 j 永远在 i 后面
    for (int i = 0; i < height.length - 1 ; i++) {
      for (int j = i + 1; j < height.length; j++) {
        int nowHeight = Math.min(height[i], height[j]);
        int area = nowHeight * (j - i);
        maxArea = Math.max(maxArea, area);
      }
    }

    return maxArea;
  }


  /**
   * 夹逼法，不断往中间靠
   */
  public int maxArea1(int[] height) {
    int maxArea = 0;
    int i = 0;
    int j = height.length - 1;
    for (; i<j ; ) {
      int nowHeight = height[i] < height[j] ? height[i++] : height[j--];
      int area = nowHeight * (j - i + 1);
      maxArea = Math.max(maxArea, area);
    }

    return maxArea;
  }

}
