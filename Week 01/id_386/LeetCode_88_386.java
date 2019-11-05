class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length - 1; i >= 0; i--) {
            // System.out.print(nums1[i]);
            if (n > 0) {
                // System.out.print(nums2[n-1]);
                nums1[i] = nums2[n-1];
                n--;
            }
        }
        
        int a, b = 0;
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1.length - 1; j++) {
                if (j <= nums1.length - 1 && nums1[j+1] < nums1[j]) {
                    a = nums1[j+1];
                    b = nums1[j];
                    nums1[j] = a;
                    nums1[j+1] = b;
                    
                } 
            }
        }
        
    }
}
