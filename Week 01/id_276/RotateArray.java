public class RotateArray {
    //1.mod N,==> nums[i] = nums[(i+k）mod N]
    //2.建立临时数组，保存前面的k个数，在复制到后面n-k位置上
    //3.

    /*public void rotate (int[] nums, int k) {

        int len = nums.length;
        int times = k%len; //为什么k&(len-1）不行
        int[] temp = new int[times];
        System.arraycopy(nums, len-times, temp,0,times);
        System.arraycopy(nums, 0, nums, times,len-times+1);
        System.arraycopy(temp, 0, nums, 0,times);
    }*/
    //暴力法
    /*public void rotate (int[] nums, int k) {
        int temp,pre;

        for (int i=0;i<k;++i){
            pre = nums[nums.length-1];
            for (int j=0;j<nums.length; ++j) {
                temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
    }*/

    //使用额外的数组
    /*public void rotate (int[] nums, int k) {
        int[] temp = new  int[nums.length];
        for (int i=0;i<nums.length;++i) {
            temp[i] = nums[(k+i)&(nums.length-1)];
        }

        System.arraycopy(temp, 0, nums, 0, nums.length);
    }*/
    //反转法
    /*public void rotate(int[] nums, int k) {
        k %= nums.length;
        revese(nums, 0, nums.length-1);
        revese(nums, 0, k-1);
        revese(nums, k, nums.length-1);
    }*/
    /*public void revese(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end ++;
        }
    }*/

}
