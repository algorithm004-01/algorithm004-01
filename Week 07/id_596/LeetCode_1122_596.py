class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        count = [0] * 1001
        answer = []
        for i in range(len(arr1)):
            count[arr1[i]] += 1
        for i in range(len(arr2)):
            while count[arr2[i]] > 0:
                answer.append(arr2[i])
                count[arr2[i]] -= 1
        for i in range(1001):
            while count[i] > 0:
                answer.append(i)
                count[i] -= 1

        return answer