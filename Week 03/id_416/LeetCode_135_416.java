/**
 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 请找出其中最小的元素。

 你可以假设数组中不存在重复元素。

 示例 1:

 输入: [3,4,5,1,2]
 输出: 1
 示例 2:

 输入: [4,5,6,7,0,1,2]
 输出: 0

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_22_416{
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}