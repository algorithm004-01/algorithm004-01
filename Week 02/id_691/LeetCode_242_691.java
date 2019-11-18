public boolean isAnagram(String s,String t) {
    if (s.length() != t.lenfth) { 
        return false;
    }
    
    int[] counter = new int[26];
    
    for (int i = 0; i < s.length(); i++) {
        counters[s.charAt(i) - 'a']++;
        counters[t.charAt(i) - 'a']--;
    }
    
    for (int count: counter) {
        return false;
    }
    
    return true;
}

public boolean isAnagram(String s,String t) {
    if (s.length() != t.length()) {
        return false;
    }
    
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1,str2);
}