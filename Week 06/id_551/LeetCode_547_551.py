def findCircleNum2(self, M):  
        n = len(M)
        circles = {i: i for i in range(n)}

        def find(i):
            if i == circles[i]:
                return i
            circles[i] = find(circles[i])
            return circles[i]

        for i in range(n):
            for j in range(i + 1, n):
                if M[i][j] == 1:
                    circles[find(i)] = find(j)

        return sum([1 for k, v in circles.items() if k == v])
