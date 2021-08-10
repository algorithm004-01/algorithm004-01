class Solution {
    public int lengthOfLIS(int[] nums) {
        int tail[] = new int[nums.length];
        int size = 0;
        
        for (int num : nums) {
            
            int i = 0, j = size;
            while (i < j) {
                int mid = i + ((j - i) >> 1);
                
                if (tail[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tail[i] = num;
            if (i == size) {
                size++;
            }
        }
        
        return size;
    }
}