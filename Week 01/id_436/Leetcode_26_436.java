
/**
 * 在这里给出对类 Leetcode_26_436 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Leetcode_26_436
{
        public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int result = 1;
        int j = 0;// previous pointer;
        for(int i = 0; i < nums.length; i++){
            if(nums[j] != nums[i]){
                result++;
                j++;
                nums[j] = nums[i];
            }
        }
        return result;
    }
}
