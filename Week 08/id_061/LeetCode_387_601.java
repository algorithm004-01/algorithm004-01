class Solution {
    public int firstUniqChar(String s) {
        int[] l = new int[26];
        for (char c:s.toCharArray())
            l[c - 'a']++;
        for (int i = 0; i <s.length() ; i++) {
            if(l[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }
}
