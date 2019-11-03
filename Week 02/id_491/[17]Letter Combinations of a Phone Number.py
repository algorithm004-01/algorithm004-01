#Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
#
# A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters. 
#
# 
#
# Example: 
#
# 
#Input: "23"
#Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
# 
#
# Note: 
#
# Although the above answer is in lexicographical order, your answer could be in any order you want. 
# Related Topics String Backtracking



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    _dict = {"2":"abc", "3":"def", "4":"ghi", "5":"jkl", "6":"mno", "7":"pqrs", "8":"tuv", "9":"wxyz"}
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]                       
        """
        if not digits:
            return []
        res = []
        self.dfs(digits, 0, "", res)
        return res

    def dfs(self, digits, idx, path, res):
        if len(path) == len(digits):
            res.append(path)
            return
        for ch in self._dict[digits[idx]]:
            self.dfs(digits, idx+1, path+ch, res)
        
#leetcode submit region end(Prohibit modification and deletion)
