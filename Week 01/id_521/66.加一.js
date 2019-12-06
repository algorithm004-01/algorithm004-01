/**
 * // 错误的解， 根本没有考虑js数字精度问题，
 * 在低精度下可以行得通， 在高精度下失效。
 * 看答案吧。
 * var plusOne = function(digits) { 
    var str = digits.join('');
    var num = (str * 1) + 1;
    return String(num).split('');
};

 */


var plusOne = function(digits) { // 错误的解释， 根本没有考虑js数字精度问题
    for(let i = digits.length - 1; i >= 0; i--) {   // >=0,不是 >0 
        debugger
        digits[i]++;
        digits[i] = digits[i] % 10
        if(digits[i] !== 0) return digits //如果全部都是9，则进行下一步。只要其中有一位不是9，就不会进行下一步
    }

    //剩下的考虑999，99等情况，这时候数组已经变为[0, 0, 0],所以数组长度需要+1，头部变为1
    digits.unshift(1);
    return digits
};




 


