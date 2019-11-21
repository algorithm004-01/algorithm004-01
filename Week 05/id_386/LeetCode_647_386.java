class Solution {
    public int countSubstrings(String s) {
        char[] arrays = s.toCharArray();
        int count = 0;
        for (int i=0; i<arrays.length; i++) {
            int j = 0;
            while(i-j >=0 && i+j < arrays.length) {
                int left = arrays[i-j];
                int right = arrays[i+j];
                if (left == right) {
                    count++;
                    j++;
                } else {
                    break;
                }
            }
            
            j = 0;

            while(i-j >=0 && i+1+j < arrays.length) {
                int left = arrays[i-j];
                int right = arrays[i+1 + j];
                if (left == right) {
                    count++;
                    j++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
