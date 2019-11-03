public class Combine {
    //思路：(n,k) = (n-1,k-1)+(n-1,k)，但是效率特别低
    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = this.combine(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(this.combine(n - 1, k));
        return result;
    }

    //
    /*public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList();
        if (n < k || k == 0) return ans;
        ans = combine(n-1, k-1);
        if (ans.isEmpty()) ans.add(new LinkedList<Integer>());
        for (List<Integer> list:ans) list.add(n);
        ans.addAll(combine(n-1, k));
        return ans;
    }*/

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=n-k+1;i++) { //原版为i<=n;改为i<=n-k+1后，时间上超过100%的人
            comb.add(i);
            combine(combs, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }
}
