class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         *  没有考虑 nums1[0] 的值是 0 时候
         *  在 leetcode 执行代码没有问题，但是在提交报数组下标越界，没有排查出来，但是在 intellijdea 里可以运行
         */
        int j = 0;
        int temp = 0;
        for (int i = 0; i<nums1.length; i++){
            if (nums2[j] < nums1[i]){
                temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
            }
            if (nums1[i] == 0){
                /**
                 *  int[] nums1 = {1,2,3,8,0,0,0,0,0,0};
                 *  int[] nums2 = {4,5,6,7,8,9};
                 *  j < nums2.length-1 防止数组下标越界，由于 j 是从0开始++，那么 nums[5] 时候 j=5 ,nums2.length=6 那么 j++ 报数组下标越界
                 *
                 *  if(j < nums2.length-1 && nums2[j] > nums2[j+1]){} 作用：
                 *  当 nums2[0] 元素比 nums2[1] 大时候，做相应处理
                 */
                if(j < nums2.length-1 && nums2[j] > nums2[j+1]){
                    temp = nums2[j];
                    nums2[j] = nums2[j+1];
                    nums2[j+1] = temp;
                }
                nums1[i] = nums2[j];
                j++;
            }
        }
    }
}
