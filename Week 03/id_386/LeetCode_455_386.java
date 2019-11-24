import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        
        if(g == null || s == null) {
            return res;
        }
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        for (int i=0, j = 0; i < g.length && j < s.length;) {
            
            if (g[i] <= s[j]) {
                i++;
                j++;
                res++;
            } else {
                j++;
            }
            
        }
    
        return res;
    }
}
