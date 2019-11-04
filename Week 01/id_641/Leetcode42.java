package vip.ruoyun;

public class Leetcode42 {
    public static int trap(int[] height) {
        if (height.length < 2) return 0;

        int area = 0;
        int tempArea = 0;
        int pos = 0;//位置  高度
        int hei = 0;

        int maxPos = 0;
        int temMax = height[0];
        //找到最大值
        for (int i = 1; i < height.length; i++) {
            if (height[i] > temMax) {
                temMax = height[i];
                maxPos = i;
            }
        }

        //然后找到面积
        for (int i = 0; i < maxPos; i++) {
            //找到第一个值
            if (pos == 0 && height[i] > 0) {
                pos = i;
                hei = height[i];
                continue;
            }
            if (height[i] < hei) {
                tempArea += hei - height[i];
            } else {
                //找到面积
                area += tempArea;
                tempArea = 0;
                pos = i;
                hei = height[i];
            }
        }

        pos = 0;//位置  高度
        hei = 0;
        for (int i = height.length - 1; i > maxPos; i--) {
            //找到第一个值
            if (pos == 0 && height[i] > 0) {
                pos = i;
                hei = height[i];
                continue;
            }
            if (height[i] < hei) {
                tempArea += hei - height[i];
            } else {
                //找到面积
                area += tempArea;
                tempArea = 0;
                pos = i;
                hei = height[i];
            }
        }
        return area;
    }

    //思路不好找
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

}
