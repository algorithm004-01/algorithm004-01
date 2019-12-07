import java.util.*;

/**
 * Created by liuyp on 2019/11/3.
 */
public class Week03 {

    //127
    public class Pair {
        private String key;
        private Integer val;

        public Pair(String key, Integer val) {
            this.key = key;
            this.val = val;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
        List<String> visited = new ArrayList<>();

        int len = beginWord.length();

        Map<String, List<String>> base = new HashMap<>();
        for (String word : wordList) {

            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, len);
                List<String> list = base.getOrDefault(newWord, new ArrayList<String>());
                list.add(word);
                base.put(newWord, list);
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        visited.add(beginWord);

        while (queue.size() > 0) {
            Pair pair = queue.poll();
            visited.add(String.valueOf(pair.getKey()));
            String curWord = String.valueOf(pair.getKey());
            int level = pair.getVal();
            for (int i = 0; i < len; i++) {
                String keyWord = curWord.substring(0, i) + '*' + curWord.substring(i + 1, len);
                List<String> baseList = base.getOrDefault(keyWord, new ArrayList<>());
                for (String baseWord : baseList) {
                    if (baseWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.contains(baseWord)) {
                        queue.add(new Pair(baseWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }

    //33
    public int search1(int[] nums, int target) {
        int mid = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public int search2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            System.out.println("left=====" + left);
            System.out.println("right=====" + right);

            int mid = (left + right) / 2;
            System.out.println("mid=====" + mid);
            System.out.println("============================");

            if (nums[mid] == target) {
                return mid;
            } else if ((nums[0] > target) && (nums[0] > nums[mid]) && (target > nums[mid])) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return -1;
    }
}
