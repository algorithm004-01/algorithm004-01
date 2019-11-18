package week03;

public class CanJump55 {
//̰�ģ�����
	public boolean canJump(int[] nums) {
		if (nums == null) {
			return false;
		}
		// pos��ʾ��Ҫ�����λ��
		int pos = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] + i >= pos) {
				pos = i;
			}

		}
		return pos == 0;

	}

	// ˳���ƣ��ٶȱȽ���
	public boolean canJump1(int[] nums) {

		if (nums == null) {
			return false;
		}
		int len = nums.length;
		boolean[] dp = new boolean[len];
		dp[0] = true;
		for (int i = 0; i < len - 1; i++) {
			if (dp[i]) {
				for (int j = i; j < len && j <= i + nums[i]; j++) {
					dp[j] = true;

				}

			}

		}
		return dp[len - 1];

	}

}
