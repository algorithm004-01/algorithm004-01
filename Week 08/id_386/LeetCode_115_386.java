class Solution {
    public int numDistinct(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if(sl==0||tl==0)return 0;
        if(sl<tl)return 0;
        if(sl==tl)return s.equals(t)?1:0;
        int[] res = new int[tl+1];
        for(int i=0;i<sl; i++){
            int pre=0;
            
            for(int j=0;j<tl; j++){
                if(j==0)pre=1;
                int temp = res[j+1];
                if(s.charAt(i)==t.charAt(j)){
                    res[j+1]=res[j+1]+pre;
                }
                pre = temp;
             } 
        }
        return res[tl];
    }
}
