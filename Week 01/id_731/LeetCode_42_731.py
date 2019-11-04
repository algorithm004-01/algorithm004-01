class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        total = 0
        for i in range(1,len(height)-1):
            m1 = max(height[0:i])
            m2 = max(height[i+1:])
            mi = min(m1,m2)
            if mi > height[i]:
                total += mi - height[i]

        return total