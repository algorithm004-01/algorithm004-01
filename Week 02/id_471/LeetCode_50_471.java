class Solution {
    public double myPow(double x, int n) {
        //terminator
        if(n == 0){
            return 1;
        }
        //prepare data
        int subN = n / 2;
        //conquer subproblem
        double subPow = myPow(x, subN);
        //process and generate final result
        return n % 2 == 0 ? subPow * subPow : n < 0 ? subPow * subPow * 1 / x : subPow * subPow * x;
    }
}