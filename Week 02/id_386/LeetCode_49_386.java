import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> letterMap = new HashMap();
        List<String> strList;
        
        for (int i = 0; i < strs.length; i++) {
            String str_s = strs[i];
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String chsSort = String.valueOf(chs);
            
            if (!letterMap.containsKey(chsSort)) {
                strList = new ArrayList();
                strList.add(str_s);
                letterMap.put(chsSort, strList);
            } else {
                strList = letterMap.get(chsSort);
                strList.add(str_s);
                letterMap.put(chsSort, strList);
            }
        }
        
        List<List<String>> newList = new ArrayList();
        
        for (List<String> list : letterMap.values()) {
            newList.add(list);
        }
        
        return newList;
    }
}
