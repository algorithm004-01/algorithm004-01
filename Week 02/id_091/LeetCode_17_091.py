from typing import List


class Solution:
    def letterCombinations(self, digits):
        if not digits:
            return []
        dic = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl", "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"}
        res = []
        self.dfs(digits, dic, 0, "", res)
        return res

    def dfs(self, digits, dic, index, path, res):
        if len(path) == len(digits):
            res.append(path)
            return
        for i in range(index, len(digits)):
            for j in dic[digits[i]]:
                self.dfs(digits, dic, i + 1, path + j, res)

    def letterCombinations2(self, digits: str) -> List[str]:
        m = {
            '2': list('abc'),
            '3': list('def'),
            '4': list('ghi'),
            '5': list('jkl'),
            '6': list('mno'),
            '7': list('pqrs'),
            '8': list('tuv'),
            '9': list('wxyz'),
        }
        if not digits: return []
        ls1 = ['']
        for i in digits:
            ls1 = [x + y for x in ls1 for y in m[i]]
        return ls1


if __name__ == '__main__':
    n = "23"
    solution = Solution()
    res = solution.letterCombinations(n)
    print(res)
