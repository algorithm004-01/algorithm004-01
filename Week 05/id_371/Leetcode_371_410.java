/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-12-02 08:52
 **/

public class Leetcode_371_410 {

    public static void main(String[] args) {

        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        int res = splitArray(nums, 2);
        System.out.println("res = " + res);
    }
    /**
     * 防解1:二分查找
     * @author Shaobo.Qian
     * @date 2019/12/2
     * @link https://leetcode-cn.com/problems/split-array-largest-sum/solution/er-fen-cha-zhao-by-coder233-2/
     * @anki 如何转换成二分查找问题的
     */
    public static int splitArray(int[] nums, int m) {
        //1.确定数组和最小值和数组和最大值的范围
        long l = 0, h = 0; //h可能超出int最大值,用 long
        for (int num : nums) {
            h += num;
            l = Math.max(l, num);
        }

        while (l < h) {
            //2.mid,寻找最合适数组和
            long mid = l + ((h - l) >> 1);
            long temp = 0;
            //cnt,被划分的子数组个数
            int cnt = 1;//初始值必须为1(因为在没有划分的时候是一整个数组)
            for (int num : nums) {
                temp += num;
                if (temp > mid) {
                    ++cnt;
                    temp = num;
                }
            }
            //cnt >m,说明选择的 mid 小了
            if (cnt > m) l = mid + 1;
            //cnt <=m,说明选择的 mid 大了1
            else h = mid;
        }
        return (int) l;
    }

}
