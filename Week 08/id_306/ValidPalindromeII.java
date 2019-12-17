package sf.week8;

/**
 * Created by LynnSun on 2019/12/8.
 * 力扣题目地址：https://leetcode-cn.com/problems/valid-palindrome-ii
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left=0, right=chars.length-1,deleteIndex=-1;
        while (left<right){
            if(chars[left]!=chars[right]){
                if(deleteIndex==-1){
                    deleteIndex=left;
                    left++;
                }else if(deleteIndex==chars.length) return false;
                else{
                    left=deleteIndex;
                    right=chars.length-left-2;
                    deleteIndex=chars.length;
                }
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
}
