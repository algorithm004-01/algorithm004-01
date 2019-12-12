/*
 * @lc app=leetcode.cn id=126 lang=javascript
 *
 * [126] 单词接龙 II
 */

// @lc code=start
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {string[][]}
 */
var findLadders = function(beginWord, endWord, wordList) {
    // 方案一 递归
    let res = [];
    let temp = [beginWord];
    if(wordList.indexOf(endWord) < 0) return [];
    findLadderHelper(beginWord, endWord, wordList, res, temp);
    return res;
  };
  let min = 10000;
  let findLadderHelper = function(beginWord, endWord, wordList, res, temp) {
      if(beginWord == endWord) {
          if(min > temp.length) {
              res.length = 0;
              min = temp.length;
              res.push([...temp]);
          } else if(min == temp.length) {
              res.push([...temp]);
          }
          return;
      }
      if(temp.length >= min){
          return;
      }
      for(let i = 0; i < wordList.length; i++) {
          let currWord = wordList[i];
          if(temp.indexOf(currWord) >= 0) continue;
          if(onlyOneDiff(currWord, beginWord)) {
              temp.push(currWord);
              findLadderHelper(currWord, endWord, wordList, res, temp);
              temp.pop();
          }
      }
  }
  let onlyOneDiff = function(word1, word2) {
    let count = 0;
    for (let i = 0; i < word1.length; i++) {
      if (word1[i] != word2[i]) {
        count++;
      }
      if (count > 1) break;
    }
    return count == 1;
  };
  // @lc code=end
  