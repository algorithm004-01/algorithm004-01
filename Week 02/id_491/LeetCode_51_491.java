class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resultString = new ArrayList<>();
        recursion(0, n);
        System.out.println(result);
        for (int i = 0; i < result.size(); i++) {
            List<String> tempResult = new ArrayList<>();
            for (int j = 0; j < result.get(i).size(); j++) {
                int currentIndex = result.get(i).get(j);
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    if (currentIndex == k) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                tempResult.add(sb.toString());
            }
            resultString.add(tempResult);
        }
        return resultString;
    }

    void recursion(int current, int n){
        if(current == n){
            return;   
        }
        List<List<Integer>> subResult = new ArrayList<>();
        if(current == 0) {
            for (int i = 0; i < n; i++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                subResult.add(temp);
            }
            this.result = subResult;
        } else {
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < result.size(); j++){
                    boolean noConlict = true;
                    for(int k = 0; k < result.get(j).size(); k++){
                        if(result.get(j).get(k) == i){
                            noConlict = false;
                            break;
                        } else if(Math.abs(current - k) == Math.abs(result.get(j).get(k) - i)){
                            noConlict = false;
                            break;
                        } 
                    }

                    if(noConlict){
                        List<Integer> subsubResult = new ArrayList<>();
                        subsubResult.addAll(result.get(j));
                        subsubResult.add(i);
                        subResult.add(subsubResult);
                    }
                }
            }
            result = subResult;
        }
        recursion(current + 1, n);
    }
}
