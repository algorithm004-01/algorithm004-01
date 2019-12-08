class Trie {
public:
	/** Initialize your data structure here. */
	struct TrieNode {
		TrieNode() {
			for (int i = 0; i < 26; ++i)
				nodes[i] = NULL;
			end_of_the_word = false;
		}
		TrieNode* nodes[26];
		bool end_of_the_word;
	};

	Trie() {

	}

	/** Inserts a word into the trie. */
	void insert(string word) {
		TrieNode* root = &root_;
		for (const auto& ch : word) {
			int index = ch - 'a';
			if (root->nodes[index] == NULL)
				root->nodes[index] = new TrieNode();
			root = root->nodes[index];
		}
		root->end_of_the_word = true;
	}

	/** Returns if the word is in the trie. */
	bool search(string word) {
		TrieNode* node = find(word);
		return node != NULL && node->end_of_the_word;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	bool startsWith(string prefix) {
		TrieNode* node = find(prefix);
		return node != NULL;
	}

private:
	TrieNode* find(string word) {
		TrieNode* root = &root_;
		for (int i = 0; i < word.size() && root != NULL; ++i) {
			int index = word[i] - 'a';
			root = root->nodes[index];
		}
		return root;
	}

private:
	TrieNode root_;
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
