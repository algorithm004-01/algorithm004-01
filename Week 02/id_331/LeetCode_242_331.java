class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++; 
        }
        
        for (int i = 0; i < t.length(); i++) {
            counter[t.charAt(i) - 'a']--;
            if(counter[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        
        return true;
    }
}