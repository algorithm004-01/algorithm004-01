class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int n : arr1) count[n]++;
        int i = 0;
        for (int n : arr2) {
            while (count[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for (int n = 0; n < count.length; n++) {
            while (count[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }
}
