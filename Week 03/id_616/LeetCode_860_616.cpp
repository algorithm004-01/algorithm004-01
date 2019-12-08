class Solution {
private:
    bool canChangeRight(int i, vector<int> &change){
        if(i == 5) {
            change[0]++;
            return true;
        }
        if(i == 10) {
            if(change[0] > 0){
                change[0]--;
                change[1]++;
            } else {
                return false;
            }
            return true;
        }
        if(i == 20) {
            if(change[1] > 0 && change[0] > 0){
                change[0]--;
                change[1]--;
                change[2]++;
                return true;
            } else {
                if(change[0] >= 3){
                    change[0] -= 3;
                    change[2]++;
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
public:
    bool lemonadeChange(vector<int>& bills) {
        vector<int> change(3);
        change[0] = 0;
        change[1] = 0;
        change[2] = 0;
        
        for(auto &i : bills){
            if(!canChangeRight(i, change)) return false;
        }
        
        return true;
    }
};