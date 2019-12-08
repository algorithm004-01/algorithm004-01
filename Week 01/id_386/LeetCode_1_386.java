class SumOfTwoNumbers {
    public int[] twoSum(int[] nums, int target) {
        int[] n = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && (nums[i] + nums[j] == target)) {
                    // System.out.println(i + ", " + j);
                    if (i < j) {
                        n[0] = i;
                        n[1] = j;   
                    } else {
                        n[0] = j;
                        n[1] = i;
                    }
                    return n;
                }
            }
        }
        return new int[0];
    }
}
