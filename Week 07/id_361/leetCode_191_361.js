/**
 * @param {number} n - a positive integer
 * @return {number}
 */
//任何数字跟掩码1进行逻辑与运算，都可以获得这个数字都最低位
//检查下一位时，将掩码左移一位
var hammingWeight = function(n) {
    let count = 0;
    let mask = 1;
    for(let i = 0;i < 32;i++){
        if((n & mask) != 0){
            count++;
        }
        mask <<= 1;
    }
    return count;
};


/**
 * @param {number} n - a positive integer
 * @return {number}
 */
// n数字的二进制的最低位的1总是对应n-1数字的二进制的0
// 相与后，其它位不变，当前位变成0
var hammingWeight = function(n) {
    let sum = 0
    while(n != 0){
        sum++
        n &= (n-1)
    }
    return sum
};


/**
 * @param {number} n - a positive integer
 * @return {number}
 */
//调用函数
var hammingWeight = function(n) {
    return ((n.toString(2).match(/1/g)) ||[]).length;
};

