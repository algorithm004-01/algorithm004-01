class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.equals(t)) {
            return true;
        }
        
        char[] letterArr = new char[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] sArrLetterCount = new int[26];
        int[] tArrLetterCount = new int[26];
        
        for (int i = 0; i < letterArr.length; i++) {
            letterArr[i] = (char)(97+i);
            // System.out.print(letterArr[i]);
        }
        
        for (int i = 0; i < sArr.length; i++) {
            for (int j = 0; j < letterArr.length; j++) {
                if (sArr[i] == letterArr[j]) {
                    sArrLetterCount[j] = sArrLetterCount[j] + 1;
                }
            }
        }
        
        for (int i = 0; i < tArr.length; i++) {
            for (int j = 0; j < letterArr.length; j++) {
                if (tArr[i] == letterArr[j]) {
                    tArrLetterCount[j] = tArrLetterCount[j] + 1;
                }
            }
        }
        
        for (int i = 0; i < sArrLetterCount.length; i++) {
            for (int j = i; i < tArrLetterCount.length; i++) {
                if (sArrLetterCount[i] == tArrLetterCount[j]) {
                    break;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}
