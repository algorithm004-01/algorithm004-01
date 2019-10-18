/**
 * Created by liuyp on 2019/10/16.
 */
public class Week01 {

    public Week01() {
    }

    //旋转数组
    public void rotate(int[] nums, int k) {

        int base = 0;
        int temp = 0;

        for (int j = 0; j < k; j++) {
            base = nums[nums.length - 1];
            for (int i = 0; i < nums.length; i++) {
                temp = nums[i];
                nums[i] = base;
                base = temp;
//                System.out.println(nums.toString());
            }
        }
//        System.out.println(nums);
    }

    public void rotate0(int[] nums, int k) {
        k = k % nums.length;

        int cnt = 0;
        for (int i = 0; cnt < nums.length; i++) {

            int cur = 0;
            int target = 0;
            int base = nums[i];
            int copy = 0;
            do {
                target = (cur + k) % nums.length;
                copy = nums[target];
                nums[target] = base;
                base = copy;
                cnt = cnt + 1;
                cur = target;
            } while (i != cur);

        }
    }


}
