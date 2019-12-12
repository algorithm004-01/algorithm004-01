'''
    # 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
    #
    # 例如，给出 n = 3，生成结果为：
    #
    # [
    #   "((()))",
    #   "(()())",
    #   "(())()",
    #   "()(())",
    #   "()()()"
    # ]
    #
    # 链接：https://leetcode-cn.com/problems/generate-parentheses
'''
class List(list):
    pass

class Solution:
    def generateParenthesis(self, n: int) -> List:
        # init res
        res = []
        levelS = ""

        def generator(left: int, right: int, n: int, s: str):
            # terminator
            if left == n and right == n:
                res.append(s)
                return

                # cache
            # s1 = s + "("
            # s2 = s + ")"

            # process
            if left < n:
                generator(left + 1, right, n, s + "(")

            if left > right and right < n:
                generator(left, right + 1 , n, s + ")")

        generator(0, 0, n, levelS)

        return res

if __name__ == '__main__':
    s = Solution()
    print("res: ", s.generateParenthesis(3))