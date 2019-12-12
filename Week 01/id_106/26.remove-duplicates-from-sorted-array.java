/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; 
        int dup = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[dup]) {    
                dup++;
                nums[dup] = nums[i];
            }
        }
        return dup+1;
    }
}
// @lc code=end


/*
[0,0,1,1,1,2,2,3,3,4]
[0,1,2,3,4]
1 遍历，记录当前指针，定义一个比当前指针快一步的指针，进行遍历，遇到与当前数不同的数字就复制到当前数字的后面
相同就跨过(前提是数组必须排序)
*/
//2 或者如果允许用另一个数组，当遇到不同的数字就放在另一数组中，直接返回新数组就可以，O(n)
//if (nums.length == 0) return 0; 当数组为空时返回0

