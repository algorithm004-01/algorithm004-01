class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> words(wordList.begin(), wordList.end());
        unordered_set<string> q_begin, q_end;
        unordered_set<string> marker;
        q_begin.insert(beginWord);
        q_end.insert(endWord);
        
        if (! words.count(endWord))
            return 0;
        
        int dist = 1;
        
        while (! q_begin.empty() && ! q_end.empty()) {
            ++dist;
            unordered_set<string> tmp_set;
            for (auto word : q_begin) {
                for (int n = 0; n < word.size(); ++n) {
                    char tmp = word[n];
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        word[n] = ch;
                        
                        if (q_end.count(word))
                            return dist;
                        
                        if (words.count(word) && ! marker.count(word)) {
                            
                            //cout << word << endl;
                            tmp_set.insert(word);
                            marker.insert(word);
                        }
                    }
                    word[n] = tmp;
                }
            }             
            q_begin = tmp_set;
            
            if (q_begin.size() > q_end.size()) {
                q_begin.swap(q_end);
            }
        }
        return 0;
    }
};
