class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int flag = 0;
        for(int i = 0; i < digits.size(); ++i){
            if(digits[i] != 9) {
                flag = 1;
                break;
            }
        }
        if(flag){
            for(int i = digits.size() -1; i >= 0; --i){
                digits[i] += 1;
                if(digits[i] == 10){
                    digits[i] = 0;
                } else {
                    break;
                } 
            }
        }else{
            digits[0] = 1;
            for(int i = 1; i < digits.size(); ++i){
                digits[i] = 0;
            }
            digits.push_back(0);
        }
        return digits;
    }
};