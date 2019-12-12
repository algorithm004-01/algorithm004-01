import java.lang.StringBuilder;
import java.util.Map;

class Solution {
    public String toLowerCase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 65 && c <= 90) {
                c += 32;
            }
            result += c;
        }
        return result;
    }
}