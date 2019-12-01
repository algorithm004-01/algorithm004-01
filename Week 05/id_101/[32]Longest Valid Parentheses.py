#Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring. 
#
# Example 1: 
#
# 
#Input: "(()"
#Output: 2
#Explanation: The longest valid parentheses substring is "()"
# 
#
# Example 2: 
#
# 
#Input: ")()())"
#Output: 4
#Explanation: The longest valid parentheses substring is "()()"
# 
# Related Topics String Dynamic Programming



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        '''
        4 cases [ (), ((, )(, )) ]
        
        dp[i] is longest valid substring ending at ith index
        if case 1 '()'
            dp[i] = dp[i-2] + 2
        case 2 can be ignored, since only do calc when encountering ')'
        case 3 is invalid
        if case 4 '))'
            dp[i-1] is longest valid substring ending at (i-1)th index
        (..   )     (    (..len is j..)    )
           i-j-2   i-j-1             i-1
            if index (i - dp[i-1] -1) is '('
                then
                dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
        '''

        res = 0
        dp = [0] * len(s)
        for i in range(1, len(s)):
            if s[i] == '(':
                continue
            j = i-1 - dp[i-1]  # for case '))', i-1 is 2nd last ')', j is index of '(' mapping to last ')'
            if j >= 0 and s[j] == '(':
                dp[i] = dp[i-1] + 2
                if j-1 >= 0:
                    dp[i] += dp[j-1]
                res = max(res, dp[i])
        return res


    def longestValidParencheses(self, s):
        '''
        use Stack to push last valid index for char '('

        :param s:
        :type s:
        :return:
        :rtype:
        '''
        stack = [-1]
        res = 0
        for idx, ch in enumerate(s):
            if ch == '(':
                # append index when encountering '('
                stack.append(idx)
            else:
                # won't be empty since append dummy index -1 at the beginning
                stack.pop()
                # after pop, if stack still not empty
                # then update max length by
                # current index subtract peek of stack
                if stack:
                    res = max(res, idx - stack[-1])
                # else append current index when stack is empty
                else:
                    stack.append(idx)
        return res

    def longestValidParentheses(self, s):
        '''
        use O(1) space complexity
        idea is to scan string twice
        1. from left to right, reset when ')' counter >= '(' counter
        2. from right to left, reset when '(' counter >= ')' counter

        use generic scan helper func

        :param s:
        :type s:
        :return:
        :rtype:
        '''
        return max(self.scan_helper(s, '('),
                   self.scan_helper(s[::-1], ')'))

    def scan_helper(self, s, benchmark):
        res = 0
        cand_len, cnt = 0, 0
        for c in s:
            if c == benchmark:
                cnt += 1
                cand_len += 1
            else:
                cnt -= 1
                if cnt < 0:
                    cnt, cand_len = 0, 0  # reset
                else:
                    cand_len += 1
                    if cnt == 0:
                        res = max(res, cand_len)
        return res


#leetcode submit region end(Prohibit modification and deletion)
