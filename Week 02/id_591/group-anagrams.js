/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const map = {};
    for(let str of strs){
        let counter = getCounter();
        let key='';
        for(let i=0; i < str.length; i++){
            counter[str[i].charCodeAt()-97]++;
        }
        for(let j=0; j < 26; j++){
            key += "#"+ counter[j];
        }
        if(!map[key]){
            map[key] = [];
        }
        map[key].push(str)
    }
    return Object.values(map);
};

var getCounter = function(){
    let counter = [];
    for(let i=0; i<26;i++){
        counter[i] = 0;
    }
    return counter;
}
let strs = ["eat", "tea", "tan", "ate", "nat", "bat"];
;
console.log(groupAnagrams(strs));