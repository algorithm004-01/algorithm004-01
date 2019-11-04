package medium;

/**
 * @author 潘磊明
 * @date 2019/10/18
 */
public class ContainerWithMostWater {

    /**
     * 进行暴力求解
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param height
     * @return
     */
//    public int maxArea(int[] height) {
//        int area = 0;
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
//            }
//        }
//        return area;
//    }

    /**
     * 两边夹逼法
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param height
     * @return
     */
    public int maxArea(int[] height){
        int area = 0;
        int i = 0, j = height.length - 1;
        do {
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            if(height[i] > height[j]){
                j--;
            }else{
                i++;
            }
        } while (i != j);
        return area;
    }
}
