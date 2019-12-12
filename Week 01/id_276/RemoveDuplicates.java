public class RemoveDuplicates {
    /*public int removeDuplicates (int[] nums) {
        //思路1 用两个数组，两个指针，
        int[] temp = new int[nums.length];

        int i=0,j=0;
        temp[i++] = nums[j++];
        for(;j<nums.length;++ j) {
            if (temp[i-1] != nums[j]) {
                temp[i++] = nums[j];
            }
        }
        System.arraycopy(temp, 0, nums, 0, i);

        return i;
    }*/

/*
    public static int removeDuplicates (int[] nums) {
        if (nums == null || nums.length < 0) {
            return 0;
        }

        int last=0,pre=1;

        while (pre < nums.length) {
            if (nums[last] != nums[pre]) {
                nums[++last] = nums[pre++];
            } else {
            pre ++;
        }
        }

        return last+1;
    }*/

    /*public static int removeDuplicates (int[] nums) {
        if (nums == null || nums.length < 0) {
            return 0;
        }

        int last=0;

        for (int i=1;i<nums.length;i++) {
            if (nums[last] != nums[i]) {
                nums[++last] = nums[i];
            }
        }
        return last+1;
    }*/
    public int removeDuplicates (int[] nums) {
        if(nums.length < 1) {
            return 0;
        }
        int[] temp = new int[nums.length];
        int j=0;
        for (int i=0;i<nums.length;++i) {
            int cnt = 0;
            int index = i;
            while (i < nums.length-1 && nums[i] == nums[i++]) {
                cnt++;
            }
        temp[j++] = nums[i-1];
        }
        System.arraycopy(temp, 0, nums, 0, j);
        return j;
    }
}
