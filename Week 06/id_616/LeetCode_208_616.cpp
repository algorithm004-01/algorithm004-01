class TrieNode {
public:
    TrieNode() {
        for(auto &&i : childrens_){
            i = nullptr;
        }
    }

    TrieNode *insert(char c) {
        if(childrens_[c-'a'] != nullptr) return childrens_[c-'a'];
        
        TrieNode *t = new TrieNode();
        childrens_[c-'a'] = t;
        return t;
    }

    TrieNode *search(char c) {
        return childrens_[c-'a'];
    }

    void setEnd() {is_end_ = true;}
    bool isEnd() {return is_end_;}
private:
    TrieNode *childrens_[26];
    bool is_end_ = false;
};

class Trie {
public:
    /** Initialize your data structure here. */
    Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode *t = root;
        for(auto &c : word){
            t = t->insert(c);
        }
        t->setEnd();
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNode *t = root;
        for(auto &c : word){
            t = t->search(c);
            if(t == nullptr) return false;
        }
        return t->isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        TrieNode *t = root;
        for(auto &c : prefix){
            t = t->search(c);
            if(t == nullptr) return false;
        }
        return true;
    }   

private:
    TrieNode *root;
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */