// [242. 有效的字母异位词 - 力扣（LeetCode）](https://leetcode-cn.com/problems/valid-anagram/)

/**
   借鉴一下使用map实现，
   0 s 和 t 的长度判断
   1 对s中每个字母进行统计
   2 在t时 如果不存在，直接返回false,存在则删除
   3 最后判断map的size
   
   ps 非空判断
   
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if(s.length!==t.length) return false;
      if(s.length===0) return true;
    const map = new Map();
    for(let i =0;i<s.length;i++) {
        const getMap = map.get(s[i])+1 || 1;
        map.set(s[i],getMap)
    }
    
    for(let j = 0;j<t.length;j++) {
        const getMap = map.get(t[j]);
        if(getMap == undefined ) return false;
         console.log(getMap,t[j])
        if(getMap===1) { 
            map.delete(t[j])
        }else {
            map.set(t[j],getMap-1);
        }
        
    }
   
    return !map.size
};

/*
* 排序
**/

var isAnagram = function(s,t){
    if(s.length!=t.length) return false;  
    var str1 = s.split('').sort();
    var str2 = t.split('').sort();
    return str1.join('') === str2.join('');
}

/**
* 哈希实现
**/

var isAnagram = function(s,t) {
  if(s.length!=t.length) return false;  
  var result = [];  // 数组
  var aCode = 'a'.charCodeAt();
  for(var i = 0;i<s.length;i++) {
      var sIndex = s[i].charCodeAt()-aCode,tIndex = t[i].charCodeAt()-aCode;
      result[sIndex]=(result[sIndex]||0) + 1;
      result[tIndex]=(result[tIndex]||0) - 1;
  }
  
  if(result.length===0) return true;
  
   for(var r = 0;r<result.length;r++){
      if(!!result[r]){
          return false;
      }     
  }
  return true;
  
}




