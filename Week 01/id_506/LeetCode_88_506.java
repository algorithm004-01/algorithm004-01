class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n -1;
        
        int a = m -1;
        int b = n -1;
        
        while(a >= 0 && b >= 0){
            
            
            if (nums1[a] <= nums2[b]){
                nums1[i] = nums2[b];
                b--;
                
            }else{
                nums1[i] = nums1[a];
                a--;
            }
            i --;
        }
        System.arraycopy(nums2, 0, nums1, 0, b + 1);
    }
}