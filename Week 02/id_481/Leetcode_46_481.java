//给定一个没有重复数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：全排列
public class P46PermutationsCC {
    public static void main(String[] args) {
        Solution solution = new P46PermutationsCC().new Solution();
        // TO TEST
        int[] arr = {1,2};
        System.out.println(solution.permute(arr));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            permuteHelper(result, new ArrayList<Integer>(), nums);
            return result;
        }

        private void permuteHelper(List<List<Integer>> result, List<Integer> temp, int[] arr) {
            if (temp.size() == arr.length) {
                result.add(new ArrayList<Integer>(temp));
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                if(temp.contains(arr[i])){
                    continue;
                }
                temp.add(arr[i]);
                permuteHelper(result, temp, arr);
                temp.remove(temp.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
