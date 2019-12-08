package id_511;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @version 1.0
 * @Description: 移动零(考点是一维数组的坐标变换)
 * @author: bingyu
 * @date: 2019/10/16 20:54
 */
public class LeetCode_283_511 {

    //解法1：快慢指针
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0;i<nums.length;++i) {
            if (nums[i] != 0) { //思路：i和j同时出发，遇到0时j停止，i继续走，当nums[i]是非零元素就和nums[j]交换;如果i==j，则自己赋给自己，所以加了限制
                if (i != j) {
                    nums[j] = nums[i]; //此时nums[j]肯定是0，因为只要j第一次遇到0，后面j会一直指向0
                    nums[i] = 0;
                }
                j++; //非0元素，j会和i一样自增，如果遇到0则i继续向前，j会在当前位置停下
            }
        }
    }

    //解法2：把0移动到数组后面，其实就是把非0数给移动到数组前面，而每个非0数需要移动的步数其实就是这个非0数前面0的个数
    public void moveZeroes2(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                count++;
            }else {
                nums[i - count] = nums[i];
            }
        }
        for(int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //解法3：滚雪球法
    public static void moveZeroes3(int[] nums){
        int snowBallSize = 0; //用来记录0的雪球size(就是遇到0的次数)
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] == 0) { //每次遍历时，当遇到0，雪球增加1
                snowBallSize++;
            } else if (snowBallSize > 0) { //如果遇到的是非零元素，且雪球大小不为0(说明之前没有遇到过零)
                int t = nums[i];
                nums[i] = 0;
                nums[i - snowBallSize] = t; //当前非零元素的位置减去雪球的大小就是与雪球要交换的位置
            }
        }
    }





    public static void main(String[] args) {
        int [] arr = {5,0,4,0,3,12};
        moveZeroes3(arr);
        System.out.println(Arrays.toString(arr));
    }




}
