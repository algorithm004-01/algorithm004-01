#include <vector>
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int count = 0;
        int size = nums.size();
        if( size < 2){
            return size;
        }
        int current_num = nums[0] + 1;
        for(int i = 0; i < size; i++){
            if(current_num != nums[i]){
                current_num = nums[i];
                nums[count++] = current_num;             
            }
        }
        
        return count;
    }
};