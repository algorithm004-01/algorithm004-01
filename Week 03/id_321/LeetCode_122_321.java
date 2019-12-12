package week03;

public class MaxProfit122 {
//���޴�
	//����1����̬�滮
	public int maxProfit_k_inf(int[] prices) {
		int n = prices.length;
		int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
		}
		return dp_i_0;
	}
	//����2��ֻҪ���ڶ���ȵ�һ��ߵ�����������Ϳ���
	 public int maxProfit2(int[] prices) {
	        int maxprofit = 0;
	        for (int i = 1; i < prices.length; i++) {
	            if (prices[i] > prices[i - 1])
	                maxprofit += prices[i] - prices[i - 1];
	        }
	        return maxprofit;
	    }

	

}
