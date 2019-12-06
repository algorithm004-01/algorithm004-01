package LeetCode_208_041;

class Trie {
	public boolean isWord;
	public char word;
	public Trie[] tries = new Trie[26];

	/**
	 * Initialize your data structure here.
	 */
	public Trie() {
		this.word = ' ';
		this.isWord = false;
	}

	/**
	 * Inserts a word into the trie.
	 */
	public void insert(String word) {
		char[] array = word.toCharArray();
		Trie node = this;
		for (int i = 0; i < array.length; i++) {
			if (node.tries[array[i] - 'a'] == null) {
				node.tries[array[i] - 'a'] = new Trie();
			}
			node = node.tries[array[i] - 'a'];
			node.word = array[i];
			if (i == array.length - 1) {//当i 等于字符长度时说明单词插入完毕，将isWord赋为true
				node.isWord = true;
			}

		}
	}

	/**
	 * Returns if the word is in the trie.
	 */
	public boolean search(String word) {
		char[] array = word.toCharArray();
		Trie node = this;
		for (int i = 0; i < array.length; i++) {
			if (node.tries[array[i] - 'a'] != null) {
				node = node.tries[array[i] - 'a'];
				if (node.word == array[i]) {
					continue;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return node.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		char[] array = prefix.toCharArray();
		Trie node = this;
		for (int i = 0; i < array.length; i++) {
			if (node.tries[array[i] - 'a'] != null) {
				node = node.tries[array[i] - 'a'];
				if (node.word == array[i]) {
					continue;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
