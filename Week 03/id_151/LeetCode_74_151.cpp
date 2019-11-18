class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.empty())
            return false;
        if (matrix[0].empty())
            return false;
        
        int left = 0;
        int right = matrix.size() * matrix[0].size() - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            int row = mid / matrix[0].size();
            int col = mid % matrix[0].size();
            
            if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return matrix[left / matrix[0].size()][left % matrix[0].size()] == target;
    }
};
