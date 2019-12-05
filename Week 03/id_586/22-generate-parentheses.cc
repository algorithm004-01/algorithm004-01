class Solution {
public:

    #if 1
    vector<string> generateParenthesis(int n) {
        vector<string> ret;
        generate(ret, "", 0, 0, n);
        return ret;
    }

    void generate(vector<string> &ans, string cur, int open, int close, int n) {
        if (cur.length() == n * 2) {
            ans.push_back(cur);
            return;
        }

        if (open < n)
            generate(ans, cur + "(", open + 1, close, n);
        if (close < open)
            generate(ans, cur + ")", open, close + 1, n);
    }
    #else
    vector<string> generateParenthesis(int n) {
        vector<string> ret;
        generate(ret, "", n, n);
        return ret;
    }

    void generate(vector<string> &ans, string cur, int left, int right) {
        if (left == 0 && right == 0) {
            ans.push_back(cur);
            return;
        }

        if (left > 0)
            generate(ans, cur + "(", left - 1, right);
        if (right > left)
            generate(ans, cur + ")", left, right - 1);
    }
    #endif
};