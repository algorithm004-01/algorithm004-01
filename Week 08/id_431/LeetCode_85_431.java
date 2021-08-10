package hard;

import java.util.Arrays;

/**
 * @author 潘磊明
 * @date 2019/12/10
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];

        //init
        Arrays.fill(right, n);

        int maxarea = 0;
        for (int i = 0; i < m; i++) {
            //update height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            //update left
            int curleft = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') left[j] = Math.max(curleft, left[j]);
                else {left[j] = 0; curleft = j + 1;}
            }
            //update right
            int curright = n;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(curright, right[j]);
                else {right[j] = n; curright = j;}
            }

            for(int j = 0; j < n; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxarea;
    }
}
