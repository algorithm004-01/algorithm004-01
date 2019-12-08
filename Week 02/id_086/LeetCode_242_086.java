// 1、判断字符串长度是否相等，且长度不相等，返回 false
// 2、讲字符串转化成字符数组，并排序
// 3、比较排序之后的字符数组，如果相等则返回 true ，否则返回 false

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] char1 = s.toCharArray();
        Arrays.sort(char1);
        char[] char2 = t.toCharArray();
        Arrays.sort(char2);
        return Arrays.equals(char1,char2);
    }
}