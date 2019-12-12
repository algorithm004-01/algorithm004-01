package easy;

import java.util.HashSet;

/**
 * @author 潘磊明
 * @date 2019/12/11
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<>();
        char[] jchars = J.toCharArray();
        for (char c : jchars) set.add(c);
        int length = 0;
        char[] chars = S.toCharArray();
        for (char c : chars) {
            if (set.contains(c)) length++;
        }
        return length;
    }
}
