class Solution {
public:
    /* 1. 暴力法 : 生成所有的序列，然后检验每一个序列 */

    /* 2. 回溯法：
     *      只有在我们知道序列仍然保持有效时才添加 '(' or ')'。我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
     *      如果我们还剩一个位置，我们可以开始放一个左括号。 如果它不超过左括号的数量，我们可以放一个右括号。
     * */
#if 0
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
//- 左括号，不要超过总数
//- 左括号 > 右个数
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