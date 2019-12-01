class DisjointSet {
public:
    DisjointSet(int n) {
        n_ = new int[n];
        count_ = n;
        for (int i = 0; i < n; ++i)
            n_[i] = i;
    }
    
    int find(int i) {
        int n = n_[i];
        while (n != n_[n]) {
            n = n_[n];
        }
        
        while (i != n) {
            int tmp = n_[i];
            n_[i] = n;
            i = n_[tmp];
        }
        
        return n;
    }
    
    void uni(int p, int q) {
        int rp = find(p);
        int rq = find(q);
        
        if (rp == rq)
            return;
        
        --count_;
        n_[rp] = rq;
    }
    
    int count() { return count_; }
    
private:
    int* n_;
    int count_;
};

class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        DisjointSet dj(M.size());
        
        for (int y = 0; y < M.size(); ++y) {
            for (int x = 0; x < M[y].size(); ++x) {
                if (M[y][x] == 1)
                    dj.uni(y, x);
            }
        }
        
        return dj.count();
    }
};
