class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int i = 0;
        int result = 0;
        while(i < g.length && j < s.length){
            if(g[i] <= s[j]) {
                i++;
                j++;
                result++;
            } else {
                j++;
            }
        }

        return result;
    }
}
