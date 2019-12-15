#!/usr/bin/env python3.7


class Solution:
    def numDecodings(self, s):
        v, w, p = 0, int(s > ""), ""
        for d in s:
            v, w, p = w, (d > "0") * w + (9 < int(p + d) < 27) * v, d
        return w


test = "12"
print(Solution().numDecodings(test))
