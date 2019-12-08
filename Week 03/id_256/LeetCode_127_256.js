/*
 * @lc app=leetcode.cn id=127 lang=javascript
 *
 * [127] 单词接龙
 */

// @lc code=start
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    // hit cog ['hot','dot','dog','lot','log','cog']
    let beginIndex = wordList.indexOf(beginWord);
    if(beginIndex >= 0) {
        wordList.splice(beginIndex, 1);
    }
    let endIndex = wordList.indexOf(endWord);
    if(endIndex < 0 || wordList.length <= 0)return 0;
    let queue = [beginWord];
    let res = 2;
    while(queue.length > 0) {
        let len = queue.length;
        for (let i = 0; i < len; i++) {
            let str = queue.shift();
            for(let j = 0; j < wordList.length; j++) {
                if (diff(str, wordList[j])) {
                    let newStr = wordList.splice(j--,1)[0];
                    if(newStr === endWord){
                        return res;
                    }else{
                        queue.push(newStr);
                    }
                }
            }
        }
        res++;
    }
    return 0;
    function diff(str1, str2) {
        let res = 0;
        for (let i = 0; i < str1.length; i++) {
            if (str1[i] !== str2[i]) {
                res += 1;
            }
            if(res>1)return false;
        }
        return true;
    }
};
// @lc code=end

