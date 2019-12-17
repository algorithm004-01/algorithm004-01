class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] c = s.toCharArray();
        int[] f = new int[s.length() + 1];
        f[0] = 1;
        for (int i = 1; i <= s.length(); ++i) {
            if (c[i - 1] != '0') {
                f[i] += f[i - 1];
            }
            if (i >= 2) {
                int val = (c[i - 2] - '0') * 10 +  c[i - 1] - '0';
                if (10 <= val && val <= 26) {
                    f[i] += f[i - 2]; 
                } 
            }
        }
        return f[s.length()];
    }
    //in:  0 2 2 6
    //ou:  1 1 2 4
}
