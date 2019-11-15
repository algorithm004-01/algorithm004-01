import java.util.*;

/**
 * @auther: TKQ
 * @Title: GroupAnagrams_49
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-11-02 10:04
 */
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }
        Map<String,List<String>> result = new HashMap<>();
        for(String word:strs){
            char[] c = word.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!result.containsKey(key)){
                result.put(key,new ArrayList());
            }
            result.get(key).add(word);
        }
        return new ArrayList(result.values());
    }
}
