class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] > max) {
                max = arr1[i];
            }
        }

        int[] memo = new int[max + 1];
        for (int i = 0; i < arr1.length; i++) {
            memo[arr1[i]] = memo[arr1[i]] + 1;
        }
        int j = 0;
        for (int p = 0; p < arr2.length; p++) {
            for (int k = 0; k < memo[arr2[p]]; k++) {
                arr1[j++] = arr2[p];
            }
            memo[arr2[p]] = 0;
        }

        for (int i = 0; i < memo.length; i++) {
            for (int k = 0; k < memo[i]; k++) {
                arr1[j++] = i;
            }
        }

        return arr1;
    }
}
