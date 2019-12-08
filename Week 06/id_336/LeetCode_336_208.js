class TreeNode{
    constructor(){
        this.END = false;
        this.links = new Array(26);  
    }
    containsKey(letter) {
        return this.links[letter.charCodeAt()-97] != undefined;
    }
    getCh(letter){
        return this.links[letter.charCodeAt()-97];
    }
    putCh(letter,newTrieNode){
        this.links[letter.charCodeAt()-97] = newTrieNode;
    }
    setEnd(){
        this.END = true;
    }
    isEnd(){
        return this.END;
    }
}
let root = null;
/**
 * Initialize your data structure here.
 */
var Trie = function() {
    root = new TreeNode();
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
let searchPrefix = (word) => {
    let currNode = root;
    for(let i = 0;i < word.length;i++){
        if(currNode.containsKey(word[i])){
            currNode = currNode.getCh(word[i]);
        }else{
            return null;
        }
    }
    return currNode;
}
Trie.prototype.insert = function(word) {
    let currNode = root;
    for(let i = 0;i < word.length;i++){
        if(!currNode.containsKey(word[i])){
            currNode.putCh(word[i],new TreeNode());
        }
        currNode = currNode.getCh(word[i]);
    }
    currNode.setEnd();
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    let currNode = searchPrefix(word);
    return currNode != null && currNode.isEnd();
};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    let currNode = searchPrefix(prefix);
    return currNode != null;
};

/** 
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */