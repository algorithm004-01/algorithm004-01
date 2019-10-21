class mergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int totalSize = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (totalSize >= 0) {
            if (m < 0) {
                nums1[totalSize--] = nums2[n--];
            } else if(n < 0){
                break;
            } else if (nums1[m] > nums2[n]) {
                nums1[totalSize--] = nums1[m--];
            } else {
                nums1[totalSize--] = nums2[n--];
            }
        }
    }
}
