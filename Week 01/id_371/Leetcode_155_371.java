import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-10 16:09
 **/

public class Leetcode_155_371 {
    /**
     * 原解1:使用数组
     * @author Shaobo.Qian
     * @date 2019/11/10
     */
    class MinStack {
        List<Integer> nums;
        int minIndex;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            nums = new ArrayList<>();
            minIndex = 0;
        }

        public void push(int x) {
            nums.add(x);
            int currIndex = nums.size() - 1;
            minIndex = nums.get(minIndex) > x ? currIndex : minIndex;
        }

        public void pop() {
            if (nums.size() == 0) return;
            nums.remove(nums.size() - 1);
            if (minIndex > (nums.size() - 1)) {
                minIndex = getMinIndex(nums);
            }
        }

        private int getMinIndex(List<Integer> nums) {
            if (nums.size() == 0) return 0;
            int minIndex = 0;
            for (int i = 1; i < nums.size(); i++) {
                minIndex = nums.get(i) < nums.get(minIndex) ? i : minIndex;
            }
            return minIndex;
        }
        public int top() {
            if (nums.size() == 0) throw new RuntimeException("has no element");
            return nums.get(nums.size() - 1);
        }

        public int getMin() {
            return nums.get(minIndex);
        }
    }
}
