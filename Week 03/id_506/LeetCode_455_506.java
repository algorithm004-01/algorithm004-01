class Solution {
    public int findContentChildren(int[] g, int[] s) {

        
        if (s.length == 0 || g.length == 0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        
        int count = 0;
        
        int gPos = g.length -1;
        for (int j = s.length -1; j >= 0 && gPos >= 0; j--){
            

    		while(s[j] < g[gPos]){


				gPos --;
				if (gPos < 0){
					return count;
				}
			}
			count ++;
			gPos --;

        }
        return count;
        
        
        
    }
}