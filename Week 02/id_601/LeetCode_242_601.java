class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() == t.length()) {
        	char[] sarray = s.toCharArray();
        	char[] tarray = t.toCharArray();
        	Arrays.sort(sarray);
        	Arrays.sort(tarray);
        	return Arrays.equals(sarray, tarray);
        }
        return false;
    }
}
