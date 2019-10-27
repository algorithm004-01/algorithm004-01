class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int iSize = nums.size();
        int sum1,sum2;
        bool bfind = false;
        for(int i=0;i<iSize;i++){
            sum1 = i;
            int tmp = target- nums[i];
            for(int j=i+1;j<iSize;j++){
                if(tmp == nums[j]){
                    sum2 = j;
                    bfind = true;
                    break;
                }
            }
            
            if(bfind)
                break;
        }
        
        vector<int> result;
        result.push_back(sum1);
        result.push_back(sum2);
        
        return result;
    }   
};