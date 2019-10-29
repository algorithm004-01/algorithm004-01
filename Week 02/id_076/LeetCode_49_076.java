import java.util.*;

/**
 * 字母异位词
 * 采用hashMap 存储排序后相同的词组
 *
 * @author tangzhenhua
 * @date 2019/10/27 21:00
 */
public class LeetCode_49_076 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(int i =0; i<strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            if(map.containsKey(key)) {
                List<String> lists = map.get(key);
                lists.add(strs[i]);
            } else {
                List<String> lists = new ArrayList<>();
                lists.add(strs[i]);
                map.put(key, lists);
            }
        }

        List<List<String>> li = new ArrayList<>();
        for(Iterator it = map.keySet().iterator(); it.hasNext();) {
            List<String> lists = map.get(it.next());
            li.add(lists);
        }

        return li;
    }

    public static void main(String[] args) {
        LeetCode_49_076 leet = new LeetCode_49_076();
        String[] array = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(leet.groupAnagrams(array));
    }
}
