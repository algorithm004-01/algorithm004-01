/**
 * Combinations
 */
public class Combinations {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        _combine(1, new ArrayList<>(),  n, k);
        return result;
    }
    
    public void _combine(int first, List<Integer> target, int n, int k){
        if(k == target.size()){
            result.add(new ArrayList<>(target));  
            return ;
        }
        
        for(int i = first; i <= n; i++){
            target.add(i);
            _combine(i + 1, target, n, k);
            target.remove(target.size() - 1);
        }
    }
}