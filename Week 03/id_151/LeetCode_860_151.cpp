class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int num5 = 0;
        int num10 = 0;
        int num20 = 0;
        for (int i = 0; i < bills.size(); ++i) {
            int cur = bills[i];
            if (cur == 5) ++num5;
            if (cur == 10) ++num10;
            if (cur == 20) ++num20;
            int left = cur - 5;
            while (left >= 20 && num20 > 0) {
                left -= 20;
                --num20;
            }
            while (left >= 10 && num10 > 0) {
                left -= 10;
                --num10;
            }
            while (left >= 5 && num5 > 0) {
                left -= 5;
                --num5;
            }
            
            if (left > 0)
                return false;
        }
        
        return true;
    }
};
