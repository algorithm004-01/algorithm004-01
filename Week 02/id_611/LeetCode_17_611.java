class Solution {
    
    //初始化数据
    HashMap<String,String> map = new HashMap(){{
      put("2", "abc");
      put("3", "def");
      put("4", "ghi");
      put("5", "jkl");
      put("6", "mno");
      put("7", "pqrs");
      put("8", "tuv");
      put("9", "wxyz");
    }};
    
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() != 0){
            digits("",digits);
        }
        return output;
    }
    
    //先用回溯实现
    public void digits(String combition,String next_digits){
        if(next_digits.length() == 0){
            output.add(combition);
            return;
        } else {
            String num = next_digits.substring(0,1);
            String letters = map.get(num);
            for(int i = 0; i < letters.length(); i++){
                String letter = letters.substring(i,i+1);
                digits(combition + letter, next_digits.substring(1));
            }
            
        }
    }
    
    List<String> output = new ArrayList();
}