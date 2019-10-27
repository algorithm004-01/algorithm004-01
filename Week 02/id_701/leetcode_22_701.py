class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        self.ans = []
        self.generate(0, 0, n, "")
        return self.ans

    def generate(self, left: int, right: int, level: int, s: str):
        if left == right == level:
            self.ans.append(s)

        if left < level:
            self.generate(left+1, right, level, s+"(")
        if right < left:
            self.generate(left, right+1, level, s+")")
