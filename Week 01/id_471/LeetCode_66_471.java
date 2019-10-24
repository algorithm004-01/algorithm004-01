//从后往前遍历，如果数字为 9 ，加 1 之后需要进位， 则继续往前遍历，直到数字不为 9 或者遍历全部数字。
// 如果遍历所有了数字，说明数组中全部都为9，只需要扩充数组，把第一个元素设为 1 
// 如果没有遍历所有数字，则在断点处对那个数字加一
class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length-1;
        
        while(index >= 0 && digits[index] == 9){
            digits[index] = 0;
            index--;
        }
        if(index < 0){
            int[] results = new int[digits.length+1];
            results[0] = 1;
            return results;
        }else{
            digits[index] = digits[index]+1;
        }
        
        return digits;
    }
}