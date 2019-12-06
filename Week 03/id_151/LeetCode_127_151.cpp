class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        map<string, set<string>> m;
        bool found = false;
        for (const auto& word : wordList) {
            for (int i = 0; i < word.size(); ++i) {
                string tmp = word;
                tmp[i] = '*';
                m[tmp].insert(word);
            }
            if (word == endWord)
                found = true;
        }
        
        if (! found) 
            return 0;
        
        deque<string> q;
        q.push_back(beginWord);
        
        set<string> marker;
        
        found = false;
        int depth = 1;
        while (! q.empty()) {
            int nq = q.size();
            for (int n = 0; n < nq; ++n) {
                string word = q.front();
                if (word == endWord) {
                    found = true;
                    return depth;
                }
                    

                q.pop_front();
                for (int i = 0; i < word.size(); ++i) {
                    string tmp = word;
                    tmp[i] = '*';

                    for (const auto& w : m[tmp]) {
                        if (marker.count(w))
                            continue;
                        marker.insert(w);
                        q.push_back(w);
                    }
                }
            }
            
            ++depth;
        }
        return found ? depth : 0;
    }
};
