package homework.week01;

import java.util.Arrays;

/**
 * 283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeros{
    /**
     * 方法一：
     *    两层for循环，第一个和第二个数判断，第一个数为0，则与第二个数换位置
     *    互换后还是0，再与第三个互换，直到非零为止。
     * @param nums
     */
    public static void moveZero1(int[] nums) {
        int temp;
        for(int i = 0; i < nums.length-1; i ++){
            for(int j = i + 1;j < nums.length ; j++){
                if(nums[i] == 0 ){
                    temp = nums[i];      
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    /**
     * 方法二：
     *     for循环把所有非零的数移动到前面，然后数组剩余位置补0
     *     使用指针i，指向需要插入的下标，使用指针j指向遍历的下标。遍历一遍，如果j指向的位置为0，
     *     则i不变，j++后移；如果j指向的位置不为0，则将j位置的元素值赋值到i位置，然后i++。
     * 参考链接：
     *     https://leetcode-cn.com/problems/move-zeroes/solution/javashi-yong-2ge-xia-biao-zhi-zhen-fu-zhi-zui-shao/
     * @param nums
     */
    public static void moveZero2(int[] nums){
        // 定义填充非零数据下标
        int i = 0;
        for(int j = 0;j < nums.length;j++){ 
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }
        // 补0
        for(int k = i;k < nums.length;k++){
            nums[k] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZero1(nums);
        System.out.println(Arrays.toString(nums));
    }
}