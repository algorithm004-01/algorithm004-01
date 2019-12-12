package week03;

import java.util.Arrays;

public class FindContentChildren455 {
	//̰�ĵ�˼���ǣ��þ���С�ı���ȥ����С����ĺ��ӣ�������Ҫ����������
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
