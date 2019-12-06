package week05;

class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            //以当前点i位置，向两边扩展,以i i+1位置向两边扩展
            result += countSegment(s, i, i);
            result += countSegment(s, i, i + 1);
        }
        return result;
    }

    private int countSegment(String s, int start, int end) {
        int count = 0;
        //start往左边跑，end往右边跑，注意边界
        while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) {
            count++;
        }
        return count;
    }
}
