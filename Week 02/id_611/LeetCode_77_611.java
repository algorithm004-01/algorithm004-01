class Solution {
    List<List<Integer>> res = new LinkedList();
    int n;
    int k;
	//最普通的回溯解法，肝不动了，先撸出来再说。。。
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(new LinkedList(),1);
        return res;
    }
    
    public void backtrack(LinkedList<Integer> list,int first){
        if(list.size() == k){
           res.add(new LinkedList(list)); 
        }
        
        for(int i = first; i <= n; ++i){
            list.add(i);
            backtrack(list,i+1);
            list.removeLast();
        }
    }
}