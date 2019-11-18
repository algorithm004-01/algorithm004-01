import java.util.*;

/**
 * Created by LynnSun on 2019/10/28.
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if(null==digits || 0==digits.length()){
            return new ArrayList<>();
        }
        Map<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> res=new LinkedList<String>();
        search("",digits,0,res,map);
        return res;
    }

    private void search(String s, String digits, int i, List<String> res, Map<Character, String> map) {
        if(i==digits.length()){
            res.add(s);
            return;
        }
        String letters =map.get(digits.charAt(i));
        for (int j=0;j<letters.length();j++){
            search(s+letters.charAt(j),digits, i+1, res, map);
        }
    }

    /**
     * 队列的方式，很巧妙
     * @param digits
     * @return
     */
    public List<String> letterCombinations_queue(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
}
