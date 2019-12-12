import java.util.HashMap;
import java.util.Map;

public class Week08 {

    public Week08() {

    }

    //387
    public int firstUniqChar(String s) {
        Map<String, Integer> temp = new HashMap<String, Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            String str = String.valueOf(s.charAt(i));
            temp.put(str, temp.getOrDefault(str, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (temp.get(String.valueOf(s.charAt(i))) == 1)
                return i;
        }
        return -1;
    }

    //151
    public String reverseWords(String s) {
        String[] sArray = s.trim().split(" +");
        int len = sArray.length - 1;
        StringBuffer ss = new StringBuffer("");
        while (len >= 0) {
            ss.append(sArray[len]);
            if (len > 0) {
                ss.append(" ");
            }
            len--;
        }
        return ss.toString();
    }


    private String killBlank(String str) {
        if (" ".equals(str)) {
            return "";
        } else {
            return str;
        }
    }

}
