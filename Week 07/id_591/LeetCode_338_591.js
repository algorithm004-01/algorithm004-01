/**
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
    let ans = [];
    for (let i = 0; i <= num; ++i){
        ans[i] = popcount(i);
    }
    return ans;
};

let popcount = function(num){
    let count = 0;
    while(num != 0){
        num = num & (num-1);
        count++;
    }
    return count;
}

