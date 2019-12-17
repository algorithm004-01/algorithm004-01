// 解题四件套
// 1. clarification 和面试官明确题意
// 2. 找出一个最优的解法
// 3. 写代码
// 4. 测试样例

// https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
// 异位词anagram
// 异位词就是字母出现的次数一样并且顺序不一样。
// 我的解法
var isAnagram = function (s, t) {
    const sArr = s.split('')
    const tArr = t.split('')
    const sobj = {}
    const tobj = {}
    sArr.forEach(item => {
        if (sobj[item]) {
            sobj[item]++
        } else {
            sobj[item] = 1
        }
    })
    tArr.forEach(item => {
        if (tobj[item]) {
            tobj[item]++
        } else {
            tobj[item] = 1
        }
    })
    let maxobj,minobj;
    if(sArr.length >= tArr.length){
         maxobj = sobj
         minobj = tobj
    }else{
        maxobj = tobj
        minobj = sobj
    }
    for (let k in maxobj) {
        if (maxobj.hasOwnProperty(k)) {
            if(!minobj[k]) return false;
            if (maxobj[k] !== minobj[k]) return false;
        }
    }
    return true;
};
const s = "a", t = "b"
// console.log(isAnagram(s, t))

// 暴力解法
// 直接sort字符串 O(Nlog(N))
var isAnagram = function(s, t) {
    const sStr = s.split('').sort().join('')
    const tStr = t.split('').sort().join('')
    if(sStr!==tStr){
        return false
    }else{
        return true
    }
}

// 2.哈希表 统计每个字符的频次
var isAnagram = function(s, t) {
    if(s.length!==t.length) return false;
    const counter = {};
    for(let i = 0; i<s.length; i++){
        if(!counter[s.charAt(i)]){
            counter[s.charAt(i)]=1
        }else{
            counter[s.charAt(i)]++
        }
        if(!counter[t.charAt(i)]){
            counter[t.charAt(i)]=-1
        }else{
            counter[t.charAt(i)]--
        }
        
    }
    for(let k in counter){
        if( counter[k]!==0){
            return false
        }
    }
    return true
}