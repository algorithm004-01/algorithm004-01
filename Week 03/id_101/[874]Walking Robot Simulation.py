#A robot on an infinite grid starts at point (0, 0) and faces north. The robot can receive one of three possible types of commands: 
#
# 
# -2: turn left 90 degrees 
# -1: turn right 90 degrees 
# 1 <= x <= 9: move forward x units 
# 
#
# Some of the grid squares are obstacles. 
#
# The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1]) 
#
# If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.) 
#
# Return the square of the maximum Euclidean distance that the robot will be from the origin. 
#
# 
#
# Example 1: 
#
# 
#Input: commands = [4,-1,3], obstacles = []
#Output: 25
#Explanation: robot will go to (3, 4)
# 
#
# 
# Example 2: 
#
# 
#Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
#Output: 65
#Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
# 
# 
#
# 
#
# Note: 
#
# 
# 0 <= commands.length <= 10000 
# 0 <= obstacles.length <= 10000 
# -30000 <= obstacle[i][0] <= 30000 
# -30000 <= obstacle[i][1] <= 30000 
# The answer is guaranteed to be less than 2 ^ 31. 
# 
# Related Topics Greedy



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def robotSim(self, commands, obstacles):
        """
        :type commands: List[int]
        :type obstacles: List[List[int]]
        :rtype: int
        """
        # facing north first
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        '''
                     x,y+1 (1)
        x-1,y (4)<-  x,y  -> x+1,y (2)
                     x,y-1 (3)
        '''
        obstacles_set = set(map(tuple, obstacles))
        res = 0
        x, y, d = 0, 0, 0
        for cmd in commands:
            if cmd == -2:  # left is (idx-1) where idx is direction index
                d = (d-1) % 4
            elif cmd == -1:  # right is (idx+1)
                d = (d+1) % 4
            else:
                while cmd > 0 and (x+dx[d], y+dy[d]) not in obstacles_set:
                    x, y = x+dx[d], y+dy[d]
                    cmd -= 1
                res = max(res, x**2 + y**2)
        return res


    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        x, y = 0, 0  # pos
        dx, dy = 0, 1  # direction (north)
        obstacles = set(map(tuple, obstacles))
        res = 0
        for cmd in commands:
            if cmd == -2:
                dx, dy = -dy, dx  # left
            elif cmd == -1:
                dx, dy = dy, -dx  # right
            else:
                for _ in range(cmd):
                    if (x+dx, y+dy) in obstacles:
                        break
                    x += dx
                    y += dy
                res = max(res, x**2 + y**2)
        return res
        
#leetcode submit region end(Prohibit modification and deletion)
