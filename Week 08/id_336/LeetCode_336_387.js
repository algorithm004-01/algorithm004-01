// #### 解法一：哈希 + 遍历
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
// #### 解法二：库函数
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