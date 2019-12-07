class Solution {
    public boolean isAnagram(String s, String t) {
        //判断字符长度是否相等
        if(s.length() != t.length()) {
            return false;
        }

        if (s.length() == 0 || t.length() == 0) {
            return false;
        }

        //统计每个字母出现的频次,字符相减
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
            nums[t.charAt(i) - 'a']--;
        }

        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}