class Solution {
    public int search(int[] nums, int target) {
        // check boundary here!!!
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        // find rotateindex first, and then binary search in ordered part
        int index = findRotateIndex(nums);
        int l, r;
        if (index == 0) {
            l = 0;
            r = nums.length - 1;
        } else {
            if (target >= nums[0]) {
                // in the left(unrotated) part
                l = 0;
                r = index;
            } else {
                // in the right(rotated) part
                l = index;
                r = nums.length - 1;
            }
        }
        return binarySearch(nums, l, r, target);
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else {
                if (nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

    public int findRotateIndex(int[] a) {
        if (a[0] < a[a.length - 1]) {
            return 0;
        }
        int l = 0, r = a.length - 1;
        int m = l + (r - l) / 2;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (a[m] > a[m + 1]) {
                return m + 1;
            } else {
                if (a[m] < a[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return m;
    }
}