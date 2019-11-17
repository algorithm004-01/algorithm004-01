# 76、 最小覆盖串


class Solution {
    public String minWindow(String s, String t) {
        int sCount = s.length();
        int tCount = t.length();
        if (sCount < tCount) {
            return "";
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[] map = new int[256];// 利用 ASSII码做映射
        for ( int i=0; i<tCount; i++) {
            map[tChar[i]]++;
        }
        int start = -1;
        int L=0,R=0;// 滑动窗口[L，R]
        int count = 0;
        int min = sCount+1;
        while(L<=sCount-tCount && R <sCount) {
            map[sChar[R]]--;
            if(map[sChar[R]]>=0) {
                count++;
            }
            if(count==tCount) {
                while(map[sChar[L]]<0) {
                    map[sChar[L]]++;
                    L++;
                }
                if (R-L<min) {
                    min=R -L;
                    start=L;
                }
                map[sChar[L++]]++;
                count--;
            }
            R++;
        }
        if(min<sCount+1) {
            return s.substring(start,start+min+1);
        }
        return "";
    }
}