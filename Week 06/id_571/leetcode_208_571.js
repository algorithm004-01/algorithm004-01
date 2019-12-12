class Trie {
  constructor() {
    this.root = {};
  }

  insert(word) {
    let node = this.root;
    for (let i = 0; i < word.length; i++) {
      node = node[word[i]] = node[word[i]] || {};
      if (i === word.length - 1) node.isTerminal = true;
    }
  }

  search(word, isPrefix) {
    let node = this.root;
    for (let c of word) {
      if (!node[c]) return false;
      node = node[c];
    }
    return isPrefix || !!node.isTerminal;
  }

  startsWith(prefix) {
    return this.search(prefix, true);
  }
}
