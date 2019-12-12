package id_511;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Description: 三数之和
 * @author: bingyu
 * @date: 2019/10/20 19:53
 */
public class LeetCode_15_511 {

    //方法1：暴力求解，首先求三数之和就是a + b + c = 0 可以看出求两数之和即 a + b = -c
    //先求出两数之和的方法
    public static int[] twoSum(int target,int[] arr){
        int tsum[] = new int[3];
        for (int i = 0;i < arr.length - 1;++i) {
            for (int j = i + 1;j < arr.length;++j) {
                if (arr[i] + arr[j] == target) {
                    tsum[0] = arr[i];
                    tsum[1] = arr[j];
                    break;
                }
            }
        }
        return tsum;
    }

    //TODO : 待去重
    // 接下来三数之和就是相当于在二数之和的基础上target是不断变化的
    public static List<List<Integer>> threeSum(int [] arr){
        List<List<Integer>> outList = new ArrayList<>();
        for (int k = 0;k < arr.length - 2;++k) {
            Integer[] tsum = new Integer[3];
            for (int i = k + 1;i < arr.length - 1;++i) {
                for (int j = i + 1;j < arr.length;++j) {
                    if (arr[i] + arr[j] == -arr[k]) { //现在问题是如何去重
                        tsum[0] = arr[k];
                        tsum[1] = arr[i];
                        tsum[2] = arr[j];
                        List<Integer> list = Arrays.asList(tsum);
                        outList.add(list);
                    }
                }
            }
        }
        return outList;
    }


    //方法二：使用hash表


    //方法三：双指针收敛
    public static List<List<Integer>> threeSum3(int [] arr){

        return null;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        //int[] ints = twoSum(9, arr);
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);
    }
}
