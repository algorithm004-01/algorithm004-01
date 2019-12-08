class DisjSet
{
private:
    std::vector<int> parent;

public:
    DisjSet(int size) : parent(std::vector<int>(size))
    {
        for (int i = 0; i < size; ++i)
            parent[i] = i;
    }

    int find(int x)
    {
        return parent[x] == x ? x : find(parent[x]);
    }

    void to_union(int x1, int x2)
    {
        parent[find(x1)] = find(x2);
    }
    
    bool is_same(int e1, int e2)
    {
        return find(e1) == find(e2);
    }
};

class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        int N = M.size();
        if( N == 0 ) return 0;

        int cnt = N;

        DisjSet disj_set(N);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(M[i][j] == 1){
                    if(!disj_set.is_same(i,j)){
                        disj_set.to_union(i,j);
                        cnt--;
                    }
                }
            }
        }
        return cnt;
    }
};