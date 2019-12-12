/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
/*
var isAnagram = function(s, t) {
    s = s.split("").sort().join("");
    t = t.split("").sort().join("");
    return s == t;
};
*/
let isAnagram = function(s, t) {
    if(s.length != t.length){
        return false;
    }
    let counter = [];
    for (let i = 0; i < 26; i++) {
      counter[i] = 0;
    }
    for(let i = 0; i< s.length; i++){
        counter[s[i].charCodeAt() - 97]++;
    }
    
    for(let i = 0; i< t.length; i++){
        counter[t[i].charCodeAt() - 97]--
        if(counter[t[i].charCodeAt() - 97] < 0){
            return false;
        }
    }
    return true;
  };
  