let TrieNode = function(){
    this.END = false;
    this.children = {};
    
}
let root = null;
/**
 * Initialize your data structure here.
 */
var Trie = function() {
    root  = new TrieNode();
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    let currNode = root;
    for(let i = 0;i < word.length;i++){
        if(currNode.children[word[i]] == undefined){
            currNode.children[word[i]] = new TrieNode();
        }
        currNode = currNode.children[word[i]];
    }
    currNode.END = true;
};
Trie.prototype.searchPrefix = (word) => {
    let currNode = root;
    for(let i = 0;i < word.length;i++){
        if(currNode.children[word[i]]){
            currNode = currNode.children[word[i]];
        }else{
            return null;
        }
    }
    return currNode;
}
/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    let currNode = this.searchPrefix(word);
    return currNode != null && currNode.END;
};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    return this.searchPrefix(prefix) != null;
};