class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(k == 1) {
            for(int i = 1; i <= n; i++){
                List<Integer> temp = new ArrayList<>(1);
                temp.add(i);
                result.add(temp);
            }
        } else if(n == k) {
            List<Integer> temp = new ArrayList<>(k);
            for(int i = 1; i <= n; i++){
                temp.add(i);
            }
            result.add(temp);
        } else {
            for(int j = k; j <= n; j++ ){
                List<List<Integer>> temp = combine(j - 1, k - 1);
                for(int a = 0; a < temp.size(); a++){
                    temp.get(a).add(j);
                }
                result.addAll(temp);
            }
        }
        
        
        return result;
    }
}
