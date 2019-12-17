class Solution(object):
    def relativeSortArray(self, arr1, arr2):
        """
        :type arr1: List[int]
        :type arr2: List[int]
        :rtype: List[int]
        """
        ans = [ 0 for _ in range(1001) ]
        result = []
        for i in range(len(arr1)):   
           ans[arr1[i]] += 1
        for j in range(len(arr2)):
            while ans[arr2[j]] > 0:
                result.append(arr2[j])
                ans[arr2[j]] -= 1

        for k in range(len(ans)):
            while ans[k] > 0:
                result.append(k)
                ans[k] -= 1
        return result
