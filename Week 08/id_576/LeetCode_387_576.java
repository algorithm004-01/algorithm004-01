package id_576;

import java.util.HashMap;
import java.util.Map;


public class LeetCode_387_576 {

    // Approach 1: Map(hashmap(O(1)), treemap(O(logN))) and for loop, O(n)/O(nlogn)
    public int firstUniqChar1(String s) {
        Map<Character,Integer> res = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            res.put(s.charAt(i), res.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (res.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    // Approach 2: brute-force, O(n^2),i 枚举所有字符，j枚举i后面的所有字符
    public int firstUniqChar2(String s) {

        return 0;
    }

    // Approach 3: hash table
    public int firstUniqChar3(String s) {

        return 0;
    }
}
