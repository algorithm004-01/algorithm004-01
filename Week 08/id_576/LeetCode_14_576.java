package id_576;

public class LeetCode_14_576 {

    /**
     * 1.brute
     * 2. approach 1
     * 3. Trie
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length ; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix2(String[] strs) {

        return null;
    }

    public String longestCommonPrefix3(String[] strs) {

        return null;
    }
}
