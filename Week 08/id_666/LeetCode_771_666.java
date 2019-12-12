import java.lang.String;
import java.lang.String;

class Solution {
    public int numJewelsInstones(String J, String s) {
        Set<Character> Jset = new HashSet();
        for (char j: J.toCharArray()) {
            Jset.add(j);
        }

        int ans = 0;
        for (char s: S.toCharArray()) {
            if (Jset.contains(s)) {
                ans++;
            }
        }

        return ans;
    }
}