
# 最开始是向北而行，x上的速度为0，y上的速度为1，x=0,y=1
# 左转就变为x=-1，y=0，得出结论：dx, dy = -dy, dx
# 验证，每个轴都验证一遍，可行！
# 向右转也是类似的方式
class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        dx, dy, x, y = 0, 1, 0, 0
        distance = 0
        obs_dict = {}
        for obs in obstacles:
            obs_dict[tuple(obs)] = 0
        for com in commands:
            if com == -2:
                dx, dy = -dy, dx
            elif com == -1:
                dx, dy = dy, -dx
            else:
                for j in range(com):
                    next_x = x + dx
                    next_y = y + dy
                    if (next_x, next_y) in obs_dict:
                        break
                    x, y = next_x, next_y
                    distance = max(distance, x*x + y*y)
        return distance
