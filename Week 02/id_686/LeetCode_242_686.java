//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
//        //暴力法，先排序，再比较 时间0(N*logN)
//        if (s.length() != t.length()){
//            return false;
//        }
//        char[] str1 = s.toCharArray();
//        char[] str2 = t.toCharArray();
//        Arrays.sort(str1);
//        Arrays.sort(str2);
//        return Arrays.equals(str1, str2);
        //创造一个字典 时间0(N)
        if(s.length() != t.length()) {
            return false;
        }
        int[] countLetters = new int[26];
        for(int i = 0; i < s.length(); i++) {
            countLetters[s.charAt(i)-'a']++;
            countLetters[t.charAt(i)-'a']--;
        }
        return Arrays.equals(countLetters, new int[26]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
