import java.security.DrbgParameters.Reseed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode_17_576  letterCombinations
 */
public class LeetCode_17_576 {

     //solution 1 : use hashmap to storage kv
     public List<String> letterCombinations1(String digits) {
         if (digits == null || digits.length() == 0 ) 
            return new ArrayList<>();
         Map<Character,String> map = new HashMap<>();
         map.put('2', "abc");
         map.put('3', "def");
         map.put('4', "ghi");
         map.put('5', "jkl");
         map.put('6', "mno");
         map.put('7', "pars");
         map.put('8', "tuv");
         map.put('9', "wxyz");
         List<String> res = new ArrayList<>();
         search("", digits, 0, res, map);
         return res;
    }

    private void search(String s, 
                        String digits, 
                        int level, //level
                        List<String> res, 
                        Map<Character, 
                        String> map) {
        //terminator
        if (level == digits.length()) {
            res.add(s);
            return;
        }
        //process current level
        String letters = map.get(digits.charAt(level));
        for (int i = 0; i < letters.length(); i++) {
            //drill down
            search(s + letters.charAt(i), digits, level + 1, res, map);
        }
        //reverse status
    }
}