class Solution {
public:
    int search(vector<int>& nums, int target) {
//         int lo = 0, hi = nums.size();
//         while (lo < hi) {
//             int mid = (lo + hi) / 2;

//             double num = (nums[mid] < nums[0]) == (target < nums[0])
//                        ? nums[mid]
//                        : target < nums[0] ? -INFINITY : INFINITY;

//             if (num < target)
//                 lo = mid + 1;
//             else if (num > target)
//                 hi = mid;
//             else
//                 return mid;
//         }
//         return -1;
        
        int lo=0,hi=nums.size()-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(nums[mid]>nums[hi]) lo=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=0;hi=nums.size()-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%nums.size();
            if(nums[realmid]==target)return realmid;
            if(nums[realmid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
};