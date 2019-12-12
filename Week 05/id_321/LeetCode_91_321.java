package week04;

import java.util.HashMap;

public class NumDecodings91 {
	/*
	 * �ⷨ1���ݹ�
	 */
	public int numDecodings1(String s) {
		return getAns(s, 0);
	}

	private int getAns(String s, int start) {
		// ���ֵ�����󷵻� 1
		if (start == s.length()) {
			return 1;
		}
		// ��ͷ�� 0,0 ����Ӧ�κ���ĸ��ֱ�ӷ��� 0
		if (s.charAt(start) == '0') {
			return 0;
		}
		// �õ���һ�ֵĻ��ֵĽ��뷽ʽ
		int ans1 = getAns(s, start + 1);
		int ans2 = 0;
		// �ж�ǰ���������ǲ���С�ڵ��� 26 ��
		if (start < s.length() - 1) {
			int ten = (s.charAt(start) - '0') * 10;
			int one = s.charAt(start + 1) - '0';
			if (ten + one <= 26) {
				ans2 = getAns(s, start + 2);
			}
		}
		return ans1 + ans2;
	}

	/*
	 * �ⷨ2���ⷨһ�ĵݹ��У��������������������������һЩ�Ѿ�����Ľ�������㣬�������ǿ����� memoization ������
	 * �������һ������ܾͱ��棬�ڶ����������ʱ��ֱ���ó����Ϳ�����
	 */
	public int numDecodings2(String s) {
		HashMap<Integer, Integer> memoization = new HashMap<>();
		return getAns(s, 0, memoization);
	}

	private int getAns(String s, int start, HashMap<Integer, Integer> memoization) {
		if (start == s.length()) {
			return 1;
		}
		if (s.charAt(start) == '0') {
			return 0;
		}
		// �ж�֮ǰ�Ƿ�����
		int m = memoization.getOrDefault(start, -1);
		if (m != -1) {
			return m;
		}
		int ans1 = getAns(s, start + 1, memoization);
		int ans2 = 0;
		if (start < s.length() - 1) {
			int ten = (s.charAt(start) - '0') * 10;
			int one = s.charAt(start + 1) - '0';
			if (ten + one <= 26) {
				ans2 = getAns(s, start + 2, memoization);
			}
		}
		// ���������
		memoization.put(start, ans1 + ans2);
		return ans1 + ans2;
	}

	/*
	 * �ⷨ3����̬�滮 dp [ i ] = dp[ i + 1 ] + dp [ i + 2 ]
	 */
	public int numDecodings3(String s) {
		int len = s.length();
		int[] dp = new int[len + 1];
		dp[len] = 1; // ���ݹ鷨�Ľ���������ʼ��Ϊ 1
		// ���һ�����ֲ����� 0 �ͳ�ʼ��Ϊ 1
		if (s.charAt(len - 1) != '0') {
			dp[len - 1] = 1;
		}
		for (int i = len - 2; i >= 0; i--) {
			// ��ǰ����ʱ 0 ��ֱ��������0 �������κ���ĸ
			if (s.charAt(i) == '0') {
				continue;
			}
			int ans1 = dp[i + 1];
			// �ж�������ĸ��ɵ������Ƿ�С�ڵ��� 26
			int ans2 = 0;
			int ten = (s.charAt(i) - '0') * 10;
			int one = s.charAt(i + 1) - '0';
			if (ten + one <= 26) {
				ans2 = dp[i + 2];
			}
			dp[i] = ans1 + ans2;

		}
		return dp[0];
	}

	/*
	 * ��̬�滮�ռ��Ż�
	 */
	public int numDecodings4(String s) {
		int len = s.length();
		int[] dp = new int[3];
		dp[len % 3] = 1;
		if (s.charAt(len - 1) != '0') {
			dp[(len - 1) % 3] = 1;
		}
		for (int i = len - 2; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				dp[i % 3] = 0; // �������Ҫ����Ϊ�ռ临���ˣ���Ҫ���ǹ���
				continue;
			}
			int ans1 = dp[(i + 1) % 3];
			int ans2 = 0;
			int ten = (s.charAt(i) - '0') * 10;
			int one = s.charAt(i + 1) - '0';
			if (ten + one <= 26) {
				ans2 = dp[(i + 2) % 3];
			}
			dp[i % 3] = ans1 + ans2;

		}
		return dp[0];
	}

	/*
	 * ��̬�滮���ռ�����Ż�
	 */
	public int numDecodings5(String s) {
		int len = s.length();
		int end = 1;
		int cur = 0;
		if (s.charAt(len - 1) != '0') {
			cur = 1;
		}
		for (int i = len - 2; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				end = cur;// end ǰ��
				cur = 0;
				continue;
			}
			int ans1 = cur;
			int ans2 = 0;
			int ten = (s.charAt(i) - '0') * 10;
			int one = s.charAt(i + 1) - '0';
			if (ten + one <= 26) {
				ans2 = end;
			}
			end = cur; // end ǰ��
			cur = ans1 + ans2;

		}
		return cur;
	}

}
