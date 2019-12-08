# 32. 最长有效括号，有效括号为（），
# 有效括号是必须成对出现的，如果接连出现把连续出现的括号累加

class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLength = 0;
        for (int i=0; i < s.length(); i++) {
            if( s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength,2*right);
            } else if ( right>=left ) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) =='(') {
                left++;
            } else {
                right++;
            }
            if ( left==right ) {
                maxLength = Math.max(maxLength,2*left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxLength;
    }
}
