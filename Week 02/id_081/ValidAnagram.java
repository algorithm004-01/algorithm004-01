/**
 * ValidAnagram
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(t == null || s == null || s.length() != t.length())
            return false;
        int size = s.length();
        int[] letters = new int[26];
        char [] arr1 = s.toCharArray();
        char [] arr2 = t.toCharArray();

        for(int i = 0; i < size; i++){
            letters[(int)arr1[i] - (int)'a'] += 1;
            letters[(int)arr2[i] - (int)'a'] -= 1;
        }
        
        for(int i = 0; i< 26; i++)
            if(letters[i] != 0)
                return false;
        return true;
    }
}