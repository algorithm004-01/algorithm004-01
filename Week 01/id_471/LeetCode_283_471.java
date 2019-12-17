//使用临时变量 j 来对应 0 的下标，遍历数组，如果发现不为 0 的元素就跟是 0 的元素交换，类似冒泡的方法，把 0 都冒到数组的后端
//时间复杂度：O(n)
//空间复杂度：O(1)

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}

//借助额外数组法，空间复杂度为O(n), 时间复杂度为O(n)

class Solution {
    public void moveZeroes(int[] nums) {
        int result[] = new int[nums.length];
        int count = 0;
        for( int i = 0; i < nums.length; i++ ){
            if(nums[i] != 0){
                result[count++] = nums[i];
            }
        }
        
        for( int i = 0; i < count; i++ ){
            nums[i] = result[i];
        }
        
        for ( int i = count; i < nums.length; i++){
            nums[i] = 0;
        }
        
    }
}

//原数组上直接操作，借助一个变量在遍历数组的过程中将非零数字从后往前重新插入数组中，后面的补零，时间复杂度为 O(n), 空间复杂度为 O(1)

class Solution {
    public void moveZeroes(int[] nums) {
        
        int insertIndex = 0;
        for( int i = 0, j = 0 ; i < nums.length; i++ ){
            if(nums[i] != 0){
                nums[insertIndex++] = nums[i];
            }
        }
        
        for(int i = insertIndex; i < nums.length; i++){
            nums[i] = 0;
        }
        
    }
}