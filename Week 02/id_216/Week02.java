import java.util.HashMap;
import java.util.Map;

public class Week02 {

    public Week02() {
    }

    public boolean isAnagram(String s, String t) {

        String[] sa = s.split("");
        String[] ta = t.split("");

        if (sa.length != ta.length) {
            return false;
        }
        HashMap<String, Integer> con = new HashMap<>();
        for (int i = 0; i < ta.length; i++) {
            if (con.get(ta[i]) != null) {
                int val = con.get(ta[i]);
                if (val + 1 == 0) {
                    con.remove(ta[i]);
                } else {
                    con.put(ta[i], val + 1);
                }
            } else {
                con.put(ta[i], 1);
            }
            if (con.get(sa[i]) != null) {
                int val = con.get(sa[i]);
                if (val - 1 == 0) {
                    con.remove(sa[i]);
                } else {
                    con.put(sa[i], val - 1);
                }
            } else {
                con.put(sa[i], -1);
            }
        }
        if (con.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j + 1 < nums.length) {
                if (map.get(i) + map.get(j + 1) == target) {
                    return new int[]{i, j + 1};
                } else {
                    j = j + 1;
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
