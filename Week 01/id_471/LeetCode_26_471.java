//使用一个变量checked来表示已经遍历过的元素，以此将数组切成两部分，checked的之前为已经遍历好的，checked之后的为未遍历的，然后在遍历过程中如果发现新元素，就把新元素放入前面半部分，最终 cheched+1 即为没有重复数字数组的长度
//时间复杂度：O(n)
//空间复杂度：O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int checked = 0;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[checked]){
                nums[++checked] = nums[i];
            }
        }
        
        return checked+1;
    }
}

//暴力法
//遍历数组，当发现相邻元素相同的时候，删掉其中一个，然后将后面所有元素往前移一位，如此循环，直到所有多余的重复元素都被移除
//时间复杂度: O(n^2)
//空间复杂度：O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        for(int i = 0; i < length; i++){
            if(i == 0){
                continue;
            }
            while(nums[i] == nums[i-1]){
                if(i == length-1){
                    length--;
                    break;
                }
                
                for(int j = i; j < length-1; j++){
                    //System.out.println(j);
                    nums[j] = nums[j+1];
                }
                length--;
            }
        }
        return length;
    }
}