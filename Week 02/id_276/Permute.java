public class Permute {
 /*   public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] used = new boolean[nums.length];
        backtrack(nums, used, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, boolean[] used,
                           List<List<Integer>> res,
                           List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i=0;i<nums.length;++i) {
            if (used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            backtrack(nums, used, res, list);
            used[i] = false;
            list.remove(list.size() - 1);
        }

    }*/

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, res, new LinkedList<>());
        return res;
    }

    private void backtrack(int[] nums, boolean[] used,
                           List<List<Integer>> res,
                           LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i=0;i<nums.length;++i) {
            if (used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            backtrack(nums, used, res, list);
            used[i] = false;
            list.removeLast();
        }

    }
}
