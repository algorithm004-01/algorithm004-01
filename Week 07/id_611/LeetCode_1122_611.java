class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] m = new int[1001];
        
        int[] ref = new int[arr1.length];
        //记录arr1数据个数
        for(int i = 0; i < arr1.length; i++) {
            m[arr1[i]]++;
        }
        
        //重新构建新数组
        int cnt = 0;
        for(int i = 0; i < arr2.length; i++) {
            while(m[arr2[i]] > 0) {
                ref[cnt++] = arr2[i];
                m[arr2[i]]--;
            }
        }
        
        //增加arr2中未出现到arr1的末尾
        for(int i = 0; i < 1001; i++) {
            while(m[i] > 0) {
                ref[cnt++] = i;
                m[i]--;
            }
        }
        return ref;
    }

}