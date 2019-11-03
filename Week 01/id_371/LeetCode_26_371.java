/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-15 10:52
 **/

public class LeetCode_26_371 {

    public static void main(String[] args) {
        //1.定义一个数组
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //2.将数组去重,返回去重后的数组的长度
        int newLen = removeDuplicates(nums);

    }

    private static int removeDuplicates(int[] nums) {//双指针法
        //0.边界值处理
        if (nums.length <= 1) {
            return nums.length;
        }
        //1.定义一个指针i,保存不重复元素的位置
        int i = 0;
        //2.定义一个指针j,保存遍历到的元素位置
        for (int j = 1; j < nums.length; j++) {
            //3.比较
            if (nums[j] > nums[i]) {
                //4.交换
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
