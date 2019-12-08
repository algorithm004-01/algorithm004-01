class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        vector<vector<string>> ret;
        // 用set大概率会超时
        unordered_set<string> sw(wordList.begin(), wordList.end());
        queue<vector<string>> q;
        q.push({beginWord});
        
        set<string> marker;
        bool flag = false;
        while (! q.empty()) {
            int qs = q.size();
            
            for (int i = 0; i < qs; ++i) {
                vector<string> cur = q.front();
                q.pop();
                
                vector<string> oneSteps = oneStepWord2(cur.back(), sw);
                for (const auto& w : oneSteps) {    
                    marker.insert(w);
                    vector<string> newLine(cur.begin(), cur.end());
                    newLine.push_back(w);
                    q.push(newLine);
                    
                    if (w == endWord) {
                        flag = true;
                        ret.push_back(newLine);
                    }
                }
            }
            if (flag)
                break;
            
            // 缩小候选集的个数, 能大大减少内存占用
            for (const auto& m : marker) sw.erase(m);
            marker.clear();
        }
        return ret;
    }
    
    vector<string> oneStepWord2(string& word, unordered_set<string>& wordList) {
        vector<string> ret;
        for (int i = 0; i < word.size(); ++i) {
            char s = word[i];
            for (char c = 'a'; c <= 'z'; ++c) {
                if (s == c)
                    continue;
                
                word[i] = c;
                if (wordList.count(word))
                    ret.push_back(word);
            }
            word[i] = s;
        }
        return ret;
    }
};
