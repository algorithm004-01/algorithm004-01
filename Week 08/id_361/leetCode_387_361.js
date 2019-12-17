/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    let hash = {};
    let result = new Map();
    for(let i = 0;i < s.length;i++){
        if(!hash[s[i]]){
            hash[s[i]] = 1;
            result.set(s[i],i);
        }else{
            result.delete(s[i]);
        }
    }
    if(result.size == 0){
        return -1;
    }
    return result.values().next().value;
};

/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    let hash = {};
    let result = [];
    for(let i = 0;i < s.length;i++){
        if(!hash[s[i]]){
            hash[s[i]] = 1;
        }else{
            hash[s[i]]++;
        }
    }
    for(let j = 0;j < s.length;j++){
        if(hash[s[j]] == 1){
            return j;
        }
    }
    return -1;
};

/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    for(let i = 0;i < s.length;i++){
        if(s.indexOf(s[i]) == s.lastIndexOf(s[i])){
            return i;
        }
    }
    return -1;
};

/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    let countingSort = (arr,maxValue) => {
        let bucket = new Array(maxValue).fill(0);
        let arrLen = arr.length;
        for(let i = 0;i < arrLen;i++){
            bucket[arr[i].charCodeAt() - 97]++;
        }
        for(let j = 0;j < arrLen;j++){
            if(bucket[arr[j].charCodeAt() - 97] == 1){
                return j;
            }
        }
        return -1;
    }
    return countingSort(s,26)
};

/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    if(s.length === 1) {
        return 0;
    }
    let base = ['a', 'b', 'c', 'd', 'e', 'f', 'g',
        'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
        'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
        'z'
    ];
    let minIndex = Number.MAX_SAFE_INTEGER, firstIndex;
    for(let i = 0; i < base.length; i++) {
        firstIndex = s.indexOf(base[i]);
        if(firstIndex >=0 && firstIndex === s.lastIndexOf(base[i])) {
            minIndex = Math.min(minIndex, firstIndex);
        }
    }
    return (minIndex ^ Number.MAX_SAFE_INTEGER) == 0 ? -1 : minIndex;
};


