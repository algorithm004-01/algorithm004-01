import java.util.HashMap;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> dollarsMap = new HashMap();
        boolean status = false;
        int change = 0;
        
        dollarsMap.put(5, 0);
        dollarsMap.put(10, 0);
        
        
        if (bills[0] == 10 || bills[0] == 20) {
            return status;
        }
        
        for (int i = 0; i < bills.length; i++) {
            System.out.println(bills[i]);
            if (bills[i] == 5) {
                dollarsMap.put(5, dollarsMap.get(5) + 1);
                status = true;
            }
                
            if (bills[i] == 10) {
                
                dollarsMap.put(10, dollarsMap.get(10) + 1);

                if (dollarsMap.get(5) == 0) {
                    return false;
                } else if (dollarsMap.get(5) - 1 >= 0) {
                    dollarsMap.put(5, dollarsMap.get(5) - 1);
                    status = true;
                }
                
            }
            
            if (bills[i] == 20) {
                
                
                // System.out.println("5+, " + dollarsMap.get(5));
                // System.out.println("10+, " + dollarsMap.get(10));
                
                if (dollarsMap.get(5) == 0) {
                    return false;
                }

                if (dollarsMap.get(5) >= 3 && dollarsMap.get(10) == 0) {
                    dollarsMap.put(5, dollarsMap.get(5) - 3);
                    status = true;
                } else if (dollarsMap.get(5) < 3 && dollarsMap.get(10) == 0) {
                    return false;
                }
                

                if (dollarsMap.get(5) >= 1 && dollarsMap.get(10) >=1) {
                    dollarsMap.put(5, dollarsMap.get(5) - 1);
                    dollarsMap.put(10, dollarsMap.get(10) - 1);
                    status = true;
                } else {
                    status = false;
                }
            }
        }
        return status;
    }
}
