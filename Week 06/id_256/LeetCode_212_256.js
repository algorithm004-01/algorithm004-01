/*
 * @lc app=leetcode.cn id=212 lang=javascript
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class TrieNode{
    constructor(){
        this.END = false;
        this.children = {};
    }
}
let root = null;
var Trie = function() {
    root = new TrieNode();
};
Trie.prototype.insert = function(word) {
    let currNode = root;
    for(let i = 0; i < word.length; i++) {
        if(currNode.children[word[i]] == undefined) {
            currNode.children[word[i]] = new TrieNode();
        }
        currNode = currNode.children[word[i]]
    }
    currNode.END = true;
};
let searchPrefix = (word) => {
    let currNode = root;
    for (let i = 0; i < word.length; i++) {
        if(currNode.children[word[i]] != undefined) {
            currNode = currNode.children[word[i]];
        }else{
            return null;
        }
    }
    return currNode;
}
Trie.prototype.search = function(word) {
    let node = searchPrefix(word);
    return node != null && node.END;
};
Trie.prototype.startsWith = function(prefix) {
    return searchPrefix(prefix) != null;
};
/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(board, words) {
    let trie = new Trie();
    //构建字典树 root
    for(let i = 0; i < words.length; i++) {
        trie.insert(words[i]);
    }
    let m = board.length;
    if(m == 0) return [];
    let n = board[0].length;
    if(n == 0) return [];
    let dx = [-1,1,0,0];
    let dy = [0,0,-1,1];
    let result = [];
    let dfs = function(i, j, currStr) {
        let str = board[i][j];
        currStr += str;
        if(trie.search(currStr) && result.indexOf(currStr) < 0) {
            result.push(currStr);
        }
        if(!trie.startsWith(currStr)){
            return;
        }
        board[i][j] = '@';
        for(let k = 0; k < 4; k++) {
            let tem_i = dx[k] + i;
            let tem_j = dy[k] + j;
            if(tem_i >= 0 && tem_i < m && tem_j >= 0 && tem_j < n && board[tem_i][tem_j] != '@') {
                dfs(tem_i, tem_j, currStr);
            }
        }
        //回溯
        board[i][j] = str;
    }
    for(let i = 0; i < m; i++) {
        for(let j = 0; j < n; j++) {
            dfs(i, j, '');
        }
    }
    return result;
};

// @lc code=end

