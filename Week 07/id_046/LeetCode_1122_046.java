class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxValue = arr1[0];
        int[] bucket = new int[1001];
        int[] result = new int[arr1.length];
    for(int i = 0;i < arr1.length;i++){
        if(maxValue < arr1[i]){
            maxValue = arr1[i];
        }
        bucket[arr1[i]]++;
    }
    int idx = 0;
    for(int j = 0;j < arr2.length;j++){
        while(bucket[arr2[j]] > 0){
            result[idx] = arr2[j];
            idx++;
            bucket[arr2[j]]--;
        }
    }
    for(int left = 0;left <= maxValue;left++){
        while(bucket[left] > 0){
            result[idx] = left;
            idx++;
            bucket[left]--;
        }
    }
    return result;
    }
}