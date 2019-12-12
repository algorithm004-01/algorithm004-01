import java.util.HashMap;
import java.util.ArrayList;
/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (43.31%)
 * Likes:    2720
 * Dislikes: 343
 * Total Accepted:    466.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */

// @lc code=start
class Solution {
    
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<Character,String>();    
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        ArrayList<String> result = new ArrayList<String>();
        
        if("".equals(digits))
            return result;
        else{
            _combaination(0,"",digits,map,result);
        }
        return result;
    }

    private void _combaination( int level, 
                                String s,
                                String digits, 
                                HashMap<Character,String> map, 
                                ArrayList<String> result){
        //terminator
        if(level==digits.length()){
            result.add(s);
            return;
        }
        //current process
        String chars = map.get(digits.charAt(level));
        for(int index = 0; index< chars.length();index++){
            //drill down
            _combaination(level+1,s+chars.charAt(index), digits, map, result);
        }
        
        //reverse
    }
}
// @lc code=end
//定义代码表的对应关系，对每一位数字可能对应的字母进行递归的排列
