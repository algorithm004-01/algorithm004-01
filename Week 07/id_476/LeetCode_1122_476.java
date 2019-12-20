public class LeetCode_1122_RelativeSortArray {
    public static void main(String[] args) {
        Solution solution = new LeetCode_1122_RelativeSortArray().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            // 计数排序
            int[] counterArr = new int[1001];
            for (int num : arr1) {
                counterArr[num] += 1;
            }
            int[] res = new int[arr1.length];
            int i = 0;
            for (int num : arr2) {
                while (counterArr[num] > 0) {
                    res[i++] = num;
                    counterArr[num] -= 1;
                }
            }
            for (int j = 0; j < counterArr.length; j++) {
                while (counterArr[j] > 0) {
                    res[i++] = j;
                    counterArr[j] -= 1;
                }
            }
            return res;
        }
    }

    class Solution1 {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {

            int counter = 0;
            for (int num : arr2) {
                for (int i = counter; i < arr1.length; i++) {
                    if (arr1[i] == num) {
                        int temp = arr1[i];
                        arr1[i] = arr1[counter];
                        arr1[counter] = temp;
                        counter++;
                    }
                }
            }
            if (counter < arr1.length) {
                Arrays.sort(arr1, counter, arr1.length);
            }
            return arr1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}