"""
一、可以走1、2、3步时，有几种情况
f(1) = 1
f(2) = f(1) + 1 = 2
f(3) = f(1) + f(2) + 1 = 4
DP  方程
dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3]
"""


def climb_stairs_3(n):
    dp = [1, 2, 4] + [0] * (n - 3) if n >= 3 else [1, 2, 4]
    for i in range(3, n):
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    return dp[n - 1]


# 空间优化
def climb_stairs_3_(n):
    if n == 1:
        return 1
    if n == 2:
        return 2
    if n == 3:
        return 4
    a, b, c = 1, 2, 4
    for _ in range(3, n):
        c, b, a = a + b + c, c, b
    return c


"""
二、可以走1、2、3步，且相邻两步不可相同，有几种情况
DP
a、重复性
    problem(n, 1) = sub(n - 1, 2) + sub(n - 1, 3)
    problem(n, 2) = sub(n - 2, 1) + sub(n - 2, 3)
    problem(n, 3) = sub(n - 3, 1) + sub(n - 3, 2)
    problem(n) = problem(n, 1) + problem(n, 2) + problem(n, 3)
"""


def climb_stairs_different(n):
    dp = [[0] * 4 for _ in range(n + 1)]
    dp[1][1] = 1
    dp[2][2] = 1
    dp[3][1], dp[3][2], dp[3][3] = 1, 1, 1
    for i in range(4, n + 1):
        dp[i][1] = dp[i - 1][2] + dp[i - 1][3]
        dp[i][2] = dp[i - 2][1] + dp[i - 2][3]
        dp[i][3] = dp[i - 3][1] + dp[i - 3][2]
    return dp[n][1] + dp[n][2] + dp[n][3]


# 空间优化
def climb_stairs_different_(n):
    if n <= 2:
        return 1
    if n == 3:
        return 3
    f11, f12, f13 = 1, 0, 0
    f21, f22, f23 = 0, 1, 0
    f31, f32, f33 = 1, 1, 1
    for _ in range(3, n):
        # 4
        f31, f32, f33, f21, f22, f23, f11, f12, f13 = f32 + f33, f21 + f23, f11 + f12, f31, f32, f33, f21, f22, f23
    return f31 + f32 + f33


if __name__ == '__main__':
    print(climb_stairs_3(3))
    print(climb_stairs_3(4))
    print(climb_stairs_3(5))
    print(climb_stairs_3_(3))
    print(climb_stairs_3_(4))
    print(climb_stairs_3_(5))
    print(climb_stairs_different(3))
    print(climb_stairs_different(4))
    print(climb_stairs_different(5))
    print(climb_stairs_different(6))
    print(climb_stairs_different(7))
    print(climb_stairs_different_(3))
    print(climb_stairs_different_(4))
    print(climb_stairs_different_(5))
    print(climb_stairs_different_(6))
    print(climb_stairs_different_(7))
