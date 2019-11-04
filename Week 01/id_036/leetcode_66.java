package com.sslz.leetcode;

/**leetcode 66
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 你可以假设除了整数 0 之外，这个整数不会以零开头。
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/plus-one
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_66 {
    public int[] solution_01(int nums[]){
     for(int i = nums.length-1;i>=0; i--) {
         if(((nums[i] + 1) % 10 )==0 ){
             nums[i]=0;
         } else {
             nums[i] = nums[i]+1;
             break;
         }
     }
     // 注意边界问题 也就是 nums[0] = 9 时
    if(nums[0]==0){
         nums = new int[nums.length+1];
         nums[0]=1;
    }
    return nums ;
}

}
