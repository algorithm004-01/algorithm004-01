class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> res;
        if(intervals.size() == 0) return res;
        if(intervals.size() == 1) return intervals;

        sort(intervals.begin(), intervals.end(), [](vector<int> i,vector<int> j) { return (i[0]<j[0]); });        

        int first = intervals[0][0];
        int second = intervals[0][1];
        for(int i = 1; i < intervals.size(); ++i){
            if(intervals[i][0] <= second) {
                second = max(intervals[i][1],second);
            } else {
                res.push_back({first,second});
                first = intervals[i][0];
                second = intervals[i][1];
            }
        }

        res.push_back({first,second});
        return res;
    }
};