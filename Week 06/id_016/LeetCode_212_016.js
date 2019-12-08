/*
 * @lc app=leetcode id=212 lang=javascript
 *
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (30.35%)
 * Likes:    1558
 * Dislikes: 84
 * Total Accepted:    145.5K
 * Total Submissions: 469.8K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
 *
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: 
 * board = [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * 
 * Output: ["eat","oath"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 * 
 * 
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(board, words) {
    // 时间复杂度 O(n)
    var Trie = function(){
        this.next = {};
        this.isEnd = false;
    }
    Trie.prototype.insert = function(word){
        let cur = this;
        for(let i = 0; i < word.length; i++){
            if(!cur.next[word[i]]){
                cur.next[word[i]] = new Trie();
            }
            cur = cur.next[word[i]];
        }
        cur.isEnd = true;
    }
    Trie.prototype.search = function(word){
        let cur = this;
        for(let i = 0; i < word.length; i++){
            if(!cur.next[word[i]]){
                return false
            }
            cur = cur.next[word[i]];
        }
        return cur.isEnd;
    }
    Trie.prototype.startWith = function(word){
        let cur = this;
        for(let i = 0; i < word.length; i++){
            if(!cur.next[word[i]]){
                return false
            }
            cur = cur.next[word[i]];
        }
        return true;
    }



    let m = board.length;
    let n = board[0].length;
    let res = [];
    // 构建trie树
    let trie = new Trie();
    words.forEach(item=>{
        trie.insert(item);
    })

    // 深度优先遍历
    let dfs = (i, j, str, node) => {
        // terminator
        if(node && node.isEnd){
            res.push(str);
            node.isEnd = false
        }
        if(i<0||j<0||i>=m||j>=n || !node){
            return;
        }
        // process
        let temp = board[i][j];
        str+=temp;
        board[i][j] = "#";
        // drill down
        dfs(i-1,j,str,node.next[temp]);
        dfs(i,j-1,str,node.next[temp]);
        dfs(i+1,j,str,node.next[temp]);
        dfs(i,j+1,str,node.next[temp]);
        // 回溯
        board[i][j] = temp;
    }
    // 时间 O(m*n)
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            dfs(i,j,"",trie);
        }
    }
    return res;
};
// @lc code=end

