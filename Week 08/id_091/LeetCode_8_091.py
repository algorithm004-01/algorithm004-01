import re
from typing import List


class Solution:
    def myAtoi(self, str: str) -> int:
        return min(max(int(*re.findall('^[\+\-]?\d+', str.strip())), -2 ** 31), 2 ** 31 - 1)


if __name__ == "__main__":
    solution = Solution()
    res = solution.myAtoi(' 420')
    print(res)
