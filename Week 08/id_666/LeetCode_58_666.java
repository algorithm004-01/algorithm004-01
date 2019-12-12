import java.lang.String;

class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        if (arr.length >=1) {
            return arr[arr.length -1].length();
        }
        return 0;
    }
}