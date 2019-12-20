class Solution {
    public int firstUniqChar(String s) {
         int[] letter=new int[26];
        for (char c:s.toCharArray()){
            letter[c-'a']++;
        }
        for (int i = 0; i <s.length() ; i++) {
            if(letter[s.charAt(i)-'a']==1) {
                return i;
            }
        }
        return -1;


    }
}