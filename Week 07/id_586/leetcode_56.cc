class Solution {
public:
    static bool comparator(const vector<int>& first, const vector<int>& second){
        if (first[0] == second[0])
            return first[1] < second[1];
        return first[0] < second[0];
    }
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        int index1, index2;
        sort (intervals.begin(), intervals.end(), comparator);

        for (index1 = 0; index1 < intervals.size(); index1++ ) {
            for (index2 = index1 + 1; index2 < intervals.size(); index2++) {
                if (intervals[index2].front() <= intervals[index1].back()) {
                    intervals[index1].back() = max(intervals[index1].back(), intervals[index2].back());
                }
                else
                    break;
            }
            intervals.erase(intervals.begin() + index1 + 1, intervals.begin() + index2);
        }

        return intervals;
    }
};
