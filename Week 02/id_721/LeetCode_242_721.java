package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author alis
 * @date 2019/10/23 9:54 AM
 * @description
 */
public class LeetCode_242_721 {

    /**
     * arrays sort and equals
     * info
     * Success:
     * Runtime:4 ms,faster than 94.06% of Java online submissions.
     * Memory Usage:37.7 MB, less than 95.75% of Java online submissions.
     */
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs, ct);
    }

    /**
     * info
     * Success:
     * Runtime:34 ms,faster than 21.61% of Java online submissions.
     * Memory Usage:38.4 MB, less than 90.83% of Java online submissions.
     */
    public boolean isAnagramHash(String s, String t) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char cs : s.toCharArray()) {
            if (charCountMap.containsKey(cs)) {
                charCountMap.put(cs, charCountMap.get(cs) + 1);
            } else {
                charCountMap.put(cs, 1);
            }
        }
        for (char ct : t.toCharArray()) {
            if (charCountMap.containsKey(ct)) {
                if (charCountMap.get(ct) == 1) {
                    charCountMap.remove(ct);
                } else {
                    charCountMap.put(ct, charCountMap.get(ct) - 1);
                }
            } else {
                return false;
            }
        }
        return charCountMap.isEmpty();
    }

}
