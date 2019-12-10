class Solution:
    def reverseWords(self, s: str) -> str:
        return ' '.join(s.split(' ')[::-1])[::-1]


if __name__ == "__main__":
    solution = Solution()
    res = solution.reverseWords("hello world, it's me")
    print(res)
