class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(), wordList.end()), head, tail;
        if (dict.find(endWord) == dict.end()) {
            return {};
        }
        head.insert(beginWord);
        tail.insert(endWord);
        unordered_map<string, vector<string>> children;
        vector<vector<string>> ladders;
        vector<string> ladder;
        ladder.push_back(beginWord);
        if (searchLadders(head, tail, dict, children, false)) {
            genLadders(beginWord, endWord, children, ladder, ladders);
        }
        return ladders;
    }
private:
    bool searchLadders(unordered_set<string>& head, unordered_set<string>& tail, unordered_set<string>& dict, unordered_map<string, vector<string>>& children, bool flip) {
        if (head.empty()) {
            return false;
        }
        if (head.size() > tail.size()) {
            return searchLadders(tail, head, dict, children, !flip);
        }
        for (string word : head) {
            dict.erase(word);
        }
        for (string word : tail) {
            dict.erase(word);
        }
        unordered_set<string> intermediate;
        bool done = false;
        for (string word : head) {
            string temp = word;
            for (int i = 0; i < word.size(); i++) {
                char t = word[i];
                for (int j = 0; j < 26; j++) {
                    word[i] = 'a' + j;
                    if (tail.find(word) != tail.end()) {
                        done = true;
                        flip ? children[word].push_back(temp) : children[temp].push_back(word);
                    } else if (!done && dict.find(word) != dict.end()) {
                        intermediate.insert(word);
                        flip ? children[word].push_back(temp) : children[temp].push_back(word);
                    }
                }
                word[i] = t;
            }
        }
        return done || searchLadders(tail, intermediate, dict, children, !flip);
    }
    
    void genLadders(string beginWord, string endWord, unordered_map<string, vector<string>>& children, vector<string>& ladder, vector<vector<string>>& ladders) {
        if (beginWord == endWord) {
            ladders.push_back(ladder);
        } else {
            for (string child : children[beginWord]) {
                ladder.push_back(child);
                genLadders(child, endWord, children, ladder, ladders);
                ladder.pop_back();
            }
        }
    }
};