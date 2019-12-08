/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    if(x<=1){
        return x;
    }
    let left = 1, right = Math.ceil(x/2);
    while(left <= right){
        let middle = parseInt((left + right)/2);
        if(middle*middle < x){
            left = middle + 1;
        }else if(middle*middle > x){
            right =  middle - 1;
        }else{
            return middle;
        }
    }
    return right;
};