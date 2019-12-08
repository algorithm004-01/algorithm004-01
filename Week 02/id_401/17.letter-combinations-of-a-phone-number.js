/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    const hashTable = {
        2:['a','b','c'],
        3:['d','e','f'],
        4:['g','h','i'],
        5:['j','k','l'],
        6:['m','n','o'],
        7:['p','q','r','s'],
        8:['t','u','v'],
        9:['w','x','y','z']
    };
    const digitsArray = digits.split('');
    return digitsArray.reduce((result,d)=>{
        const item = hashTable[d];
        if(result.length === 0) return item;
        if(item.length === 0) return result;
        const temp=[];
        result.map(r=>{
            item.map(i=>{
               temp.push(r+i);
            })
        })
        return temp;
    },[]);
    
};