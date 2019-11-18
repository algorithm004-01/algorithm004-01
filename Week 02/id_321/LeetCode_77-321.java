package week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combine77 {

/*
 * ���ݼ�֦����
 *  p ����������һ��ջ
 *	i �ļ���ֵ���㣺 n - i + 1 = (k - pre.size())��
 *	���ؼ���n - i + 1 �Ǳ����� [i,n] �ĳ��ȡ�
 *	k - pre.size() ��ʣ�»�ҪѰ�ҵ����ĸ�����	
 */
	 private List<List<Integer>> result = new ArrayList<>();

	    public List<List<Integer>> combine(int n, int k) {
	        if (n <= 0 || k <= 0 || n < k) {
	            return result;
	        }
	        findCombinations(n, k, 1, new Stack<>());
	        return result;
	    }

	   
	    private void findCombinations(int n, int k, int index, Stack<Integer> p) {
	        if (p.size() == k) {
	            result.add(new ArrayList<>(p));
	            return;
	        }
	        for (int i = index; i <= n - (k - p.size()) + 1; i++) {
	            p.push(i);
	            findCombinations(n, k, i + 1, p);
	            p.pop();
	        }
	    }

	    public static void main(String[] args) {
	        List<List<Integer>> lists = new Combine77().combine(4, 2);
	        System.out.println(lists);
	    }
	}

	

}
