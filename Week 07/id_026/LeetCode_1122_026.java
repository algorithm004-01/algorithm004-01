public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] m = new int[1001];
        
        int[] ref = new int[arr1.length];
        
        for(int i = 0; i < arr1.length; i++) {
            m[arr1[i]]++;
        }
        
        int cnt = 0;
        for(int i = 0; i < arr2.length; i++) {
            while(m[arr2[i]] > 0) {
                ref[cnt++] = arr2[i];
                m[arr2[i]]--;
            }
        }
        
        for(int i = 0; i < 1001; i++) {
            while(m[i] > 0) {
                ref[cnt++] = i;
                m[i]--;
            }
        }
        return ref;
}