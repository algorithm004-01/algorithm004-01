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
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
//        char[] charS =  s.toCharArray();
//        char[] charT =  t.toCharArray();
//        Arrays.sort(charS);
//        Arrays.sort(charT);
//        if(Arrays.equals(charS,charT)){
//            return true;
//        }
//        return false;
        //hash表法,初始化一个记录26个字母出现次数的数组
    int[] count = new int[26];
            for(int i=0;i<s.length();i++){
                count[s.charAt(i)- 'a']++;
                count[t.charAt(i)- 'a']--;
            }
            for (int i: count){
                if(i !=0){
                    return false;
                }
            }
            return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
