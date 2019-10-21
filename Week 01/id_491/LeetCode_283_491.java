class moveZeroes {
    public void moveZeroes(int[] nums) {
        int notZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                if (notZero != i) {
                    nums[notZero] = nums[i];
                    nums[i] = 0;
                }
                notZero++;
            }
        }
    }
}
