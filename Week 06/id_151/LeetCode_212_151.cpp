class Trie {
public:
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
    
    bool search(string word) {
        TrieNode* node = find(word);
        return node != NULL && node->end_of_the_word;
    }
    
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


class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        Trie trie;
        set<string> res;
        for (const auto& word : words)
            trie.insert(word);
        
        int dx[4] = {0,0,-1,1};
        int dy[4] = {1,-1,0,0};
    
        for (int y = 0; y < board.size(); ++y) {
            for (int x = 0; x < board[y].size(); ++x) {
                dfs(trie, dx, dy, x, y, "", res, board);        
            }
        }
        
        return vector<string>(res.begin(), res.end());
    }
    
    void dfs(Trie& trie, int* dx, int* dy, int x, int y, 
        string cur, set<string>& res, vector<vector<char>>& board) {
        if (y >= board.size() || x >= board[y].size() || board[y][x] == '#')
            return;
        
        char tmp = board[y][x];
        cur += tmp;
        
        if (! cur.empty() && ! trie.startsWith(cur))
            return;
        
        if (trie.search(cur))
            res.insert(cur);
        
        board[y][x] = '#';
        for (int i = 0; i < 4; ++i) {
            dfs(trie, dx, dy, x + dx[i], y + dy[i], cur, res, board);
        }
        board[y][x] = tmp;
    }
};
