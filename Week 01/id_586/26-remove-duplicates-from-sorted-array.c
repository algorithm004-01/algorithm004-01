/* 双指针法:
 *  两个指针 ii 和 jj，其中 ii 是慢指针，而 jj 是快指针。只要 nums[i] = nums[j]nums[i]=nums[j]，我们就增加 jj 以跳过重复项
 */
int removeDuplicates(int* nums, int numsSize){
    if (numsSize <= 0) return 0;
    
    int i = 0;
    int j = 0;
    
    for (j = 1; j < numsSize; j++) {
        if (nums[i] != nums[j]) {
            i++;
            nums[i] = nums[j];
        }
    }
    
    return i + 1;
}
