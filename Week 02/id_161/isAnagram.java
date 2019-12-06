// 都转化为char数组，排序后比较数组，时间复杂度n，空间复杂度n
public static boolean isAnagram1(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    char[] sCharArray = s.toCharArray();
    Arrays.sort(sCharArray);
    char[] tCharArray = t.toCharArray();
    Arrays.sort(tCharArray);
    boolean equals = Arrays.equals(sCharArray, tCharArray);
    return equals;
}

// 26个小写字母，生成26长度的数组，一遍轮询++或--，最后判断数组每个数是否为0
public static boolean isAnagram2(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] hash = new int[26];
    for (int i = 0; i < s.length(); i++) {
        hash[s.charAt(i) - 'a']++;
        hash[t.charAt(i) - 'a']--;
    }
    for (int num : hash) {
        if (num != 0) {
            return false;
        }
    }
    return true;
}

