// leetcode - https://leetcode-cn.com/problems/search-a-2d-matrix 

func searchMatrix(matrix [][]int, target int) bool {
    len1 := len(matrix)
    if len1 == 0 {
        return false
    }
    len2 := len(matrix[0])
    left, right := 0, len1*len2-1
    
    for left <= right {
        mid := (left + right) / 2
        x,y := (mid/len2), (mid%len2)
        if matrix[x][y] == target {
            return true
        } else if matrix[x][y] < target {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return false
}