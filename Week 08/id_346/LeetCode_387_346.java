package suanfa;

import java.util.HashMap;

/**
 * @auther: TKQ
 * @Title: LeetCode_387_346
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-12-08 17:41
 */
public class LeetCode_387_346 {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hm = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hm.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
