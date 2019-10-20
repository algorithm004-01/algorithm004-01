class removeDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int notDuplicate = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                notDuplicate++;
                if (notDuplicate != i) {
                    nums[notDuplicate] = nums[i];
                }
            }
        }
        return notDuplicate + 1;
    }
}
