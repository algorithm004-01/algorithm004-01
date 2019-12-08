/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-11-19 22:30:26
 * @LastEditTime: 2019-11-22 10:19:09
 */
/*
 * @lc app=leetcode id=208 lang=javascript
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (41.09%)
 * Likes:    2046
 * Dislikes: 36
 * Total Accepted:    218.5K
 * Total Submissions: 520K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 *
 *
 * Note:
 *
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 *
 */

// @lc code=start
// 时间复杂度 O(n)
/**
 * Initialize your data structure here.
 */
var Trie = function() {
  this.isWord = false;
  this.next = {};
};

/**
 * Inserts a word into the trie.
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
  let cur = this;
  for (let i = 0; i < word.length; i++) {
    if (!cur.next[word[i]]) {
      cur.next[word[i]] = new Trie();
    }
    cur = cur.next[word[i]];
  }
  cur.isWord = true;
};

/**
 * Returns if the word is in the trie.
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
  let cur = this;
  for (let i = 0; i < word.length; i++) {
    if (!cur.next.hasOwnProperty(word[i])) {
      return false;
    }
    cur = cur.next[word[i]];
  }
  return cur.isWord;
};

/**
 * Returns if there is any word in the trie that starts with the given prefix.
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
  let cur = this;
  for (let i = 0; i < prefix.length; i++) {
    if (!cur.next.hasOwnProperty(prefix[i])) {
      return false;
    }
    cur = cur.next[prefix[i]];
  }
  return true;
};

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
// @lc code=end

let trie = new Trie();

trie.insert("apple");
console.log(trie);
console.log(trie.search("appl"));
console.log(trie.search("apple"));
console.log(trie.startsWith("app"));
