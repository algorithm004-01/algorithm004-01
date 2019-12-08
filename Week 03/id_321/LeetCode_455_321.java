package week03;

import java.util.Arrays;

public class FindContentChildren455 {
	//贪心的思想是，用尽量小的饼干去满足小需求的孩子，所以需要进行排序先
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int sum = 0;
		int leng = 0, lens = 0;

		while (leng < g.length && lens < s.length) {
			if (s[lens] >= g[leng]) {
				leng++;
				lens++;
				sum++;
			} else {
				lens++;
			}

		}
		return sum;

	}
}
