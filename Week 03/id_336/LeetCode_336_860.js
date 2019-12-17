/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
    var five = 0;
    var ten = 0;
    var len = bills.length;
    for(var i = 0;i<len;i++){
        if(bills[i] == 5){
            five++;
        }else if(bills[i] == 10){
            if(five == 0){
                return false
            };
            five--;
            ten++;
        }else if(bills[i] == 20){
            if(ten > 0 && five > 0){
                ten--;
                five--;
            }else if(five >= 3){
                five -= 3;
            }else{
                return false;
            }
        }
    }
    return true;
};