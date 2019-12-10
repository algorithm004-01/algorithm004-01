class Solution {
    public int longestValidParentheses(String s) {
        int left =0, right =0,max =0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) =='('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                max = Math.max(max,right*2);
            }else if(right >= left){
                //当右括号数量过多，从左往右数就可以归零
                left = right =0;
            }
        }
        left = right =0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i)=='(')
                left++;
            else
                right++;
            if(left == right)
                max = Math.max(max, left *2);
            else if(left >= right)
                left = right =0;
        }
        return max;
    }
}