import java.util.*;
/**
 * 单词接龙
 */
class Solution {

    /**
     * 单词接龙(228ms)BFS
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        wordList.add(beginWord);
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast(endWord);
        int level = 1, listSize = wordList.size();
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String pop = queue.pollFirst();
                for (int j = 0; j < listSize; j++) {
                    String str = wordList.get(j);
                    if (!str.equals("") && isOneDiff(str, pop)) {
                        if (str.equals(beginWord)) return level;
                        queue.addLast(str);
                        wordList.set(j, "");
                    }
                }
            }
        }
        return 0;
    }

    private boolean isOneDiff(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
            if (count > 1) return false;
        }
        return true;
    }

    /**
     * 单词接龙(48ms)BFS
     * 空间换时间
     */
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        HashMap<String, List<String>> map = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                if (map.containsKey(newWord)) map.get(newWord).add(word);
                else {
                    List<String> l = new ArrayList<>();
                    l.add(word);
                    map.put(newWord, l);
                }
            }
        });
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        int level = 1;
        queue.addLast(beginWord);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.removeFirst();
                for (int j = 0; j < len; j++) {
                    String newWord = word.substring(0, j) + "*" + word.substring(j + 1);
                    for (String str : map.getOrDefault(newWord, new ArrayList<>())) {
                        if (str.equals(endWord)) return level;
                        if (!set.contains(str)) {
                            queue.addLast(str);
                            set.add(str);
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 单词接龙(30ms) 双向BFS
     * 空间换时间
     */
    private HashMap<String, List<String>> hp = new HashMap<>();

    public int ladderLength4(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        int len = beginWord.length();
        wordList.forEach(word -> {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                if (hp.containsKey(newWord)) hp.get(newWord).add(word);
                else {
                    List<String> l = new ArrayList<>();
                    l.add(word);
                    hp.put(newWord, l);
                }
            }
        });
        LinkedList<Pair<String, Integer>> beginQueue = new LinkedList<>();
        LinkedList<Pair<String, Integer>> endQueue = new LinkedList<>();
        beginQueue.addLast(new Pair<>(beginWord, 1));
        endQueue.addLast(new Pair<>(endWord, 1));

        HashMap<String, Integer> beginSet = new HashMap<>();
        HashMap<String, Integer> endSet = new HashMap<>();
        beginSet.put(beginWord, 1);
        endSet.put(endWord, 1);

        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int r1 = ladderLength4Helper(beginQueue, beginSet, endSet, len);
            if (r1 > -1) return r1;
            int r2 = ladderLength4Helper(endQueue, endSet, beginSet, len);
            if (r2 > -1) return r2;
        }
        return 0;
    }

    private int ladderLength4Helper(LinkedList<Pair<String, Integer>> queue,
                                    HashMap<String, Integer> set,
                                    HashMap<String, Integer> otherSet,
                                    int len) {
        Pair<String, Integer> pair = queue.removeFirst();
        String word = pair.getKey();
        int level = pair.getValue();
        for (int j = 0; j < len; j++) {
            String newWord = word.substring(0, j) + "*" + word.substring(j + 1);
            for (String str : hp.getOrDefault(newWord, new ArrayList<>())) {
                if (otherSet.containsKey(str)) return level + otherSet.get(str);
                if (!set.containsKey(str)) {
                    queue.addLast(new Pair<>(str, level + 1));
                    set.put(str, level + 1);
                }
            }
        }
        return -1;
    }
}