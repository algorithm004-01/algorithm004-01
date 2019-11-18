package sanlie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zimuyiwei49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) {
			return Collections.emptyList();// ���ؿյ�����
		}
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, List<String>> ans = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] chars = str.toCharArray();// ���ַ���ת��Ϊ�ַ�����
			Arrays.sort(chars);
			String key = String.valueOf(chars);// ��char����ת�����ַ���
			if (!ans.containsKey(key)) {
				ans.put(key, new ArrayList<String>());
			}
			ans.get(key).add(str);
		}
		result.addAll(ans.values());
		return result;
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
