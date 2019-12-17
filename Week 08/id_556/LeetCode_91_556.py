# O(n) time/space
def numDecodings(s: str) -> int:
    n = len(s)
    if not s or s[0] == "0":
        return 0
    # dp[i] denotes the num of decoding for s[:i]
    dp = [0] * (n + 1)
    dp[0] = 1
    dp[1] = 1
    for i in range(1, n):
        if s[i] == "0":
            if s[i - 1] == "1" or s[i - 1] == "2":
                dp[i + 1] = dp[i - 1]
            else:
                return 0
        else:
            if s[i - 1] == "1" or (s[i - 1] == "2" and "1" <= s[i] <= "6"):
                dp[i + 1] = dp[i] + dp[i - 1]
            else:
                dp[i + 1] = dp[i]
    return dp[-1]


# O(n) time, O(1) space
def numDecodings2(s):
    n = len(s)
    if not s or s[0] == "0":
        return 0
    pre, cur = 1, 1
    for i in range(1, n):
        if s[i] == "0":
            if s[i - 1] == "1" or s[i - 1] == "2":
                cur = pre
            else:
                return 0
        else:
            if s[i - 1] == "1" or (s[i - 1] == "2" and "1" <= s[i] <= "6"):
                tmp = cur
                cur += pre
                pre = tmp
            else:
                pre = cur
    return cur


print(numDecodings("0"))
print(numDecodings2("226"))
print("226"[:2])
