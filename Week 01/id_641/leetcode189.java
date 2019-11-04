package vip.ruoyun;

import java.util.Arrays;

public class leetcode189 {

    //空间复杂度 O(k) k<nums.length 时间复杂度 O(n)
    //字节使用内存拷贝的方式进行
    public static void rotate(int[] nums, int k) {
        //只要得到位置就可以
        // k = 2
        //求坐标  [ length-2 ,length]
        if (k > nums.length) {
            k = k - nums.length;//
        } else if (k == nums.length) {
            return;
        }
        //[ length-2 ,length] ,[0, length-3]
        int[] temp = new int[k];
        System.arraycopy(nums, nums.length - k, temp, 0, k);//把后面的拷贝到 临时的内存空间中
        System.arraycopy(nums, 0, nums, k, nums.length - k);//把数组中的 前面的元素,拷贝到 移动后的位置中
        System.arraycopy(temp, 0, nums, 0, temp.length);//把临时数组中的内容拷贝到 前面的位置
        System.out.println(Arrays.toString(nums));
    }


    //使用环状替换,空间复杂度 O(n)
    public static void rotate2(int[] nums, int k) {
        if (nums.length == 0 || k == nums.length) {
            return;
        }
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(k + i) % nums.length] = nums[i];
        }
        System.out.println(Arrays.toString(newNums));
    }

    //使用环状替换,空间复杂度 O(1),写法暂时没有思考出来
    public static void rotate3(int[] nums, int k) {
        if (nums.length == 0 || k == nums.length) {
            return;
        }
        k = k % nums.length;
        int temp;
        for (int i = 0; i < k; i++) {
//           for (int j = 0;i<k)
        }
//        System.out.println(Arrays.toString(newNums));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        rotate(nums, 10);
        rotate2(nums, 5);
    }
}
