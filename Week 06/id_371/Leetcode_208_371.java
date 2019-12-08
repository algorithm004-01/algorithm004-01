/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-19 10:24
 **/

public class Leetcode_208_371 {
    /**
     * 仿解1:字典树
     *
     * @author Shaobo.Qian
     * @date 2019/11/19
     * @link: https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/shi-xian-trie-qian-zhui-shu-by-leetcode/
     */
    class Trie {
        class TrieNode {
            private TrieNode[] links;//索引结点数组(R links to node children)
            private final int R = 26;
            private boolean isEnd;

            public TrieNode() {
                links = new TrieNode[R];
            }

            public boolean containsKey(char ch) {
                return links[ch - 'a'] != null;
            }

            public TrieNode get(char ch) {
                return links[ch - 'a'];
            }

            public void put(TrieNode node, char ch) {
                links[ch - 'a'] = node;
            }

            public void setEnd() {
                isEnd = true;
            }

            public boolean isEnd() {
                return isEnd;
            }

        }

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         * 一层层往下插入
         */
        public void insert(String word) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (char currChar : chars) {
                if (!node.containsKey(currChar)) {
                    node.put(new TrieNode(), currChar);
                }
                node = node.get(currChar); //得到下一层的节点
            }
            node.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            char[] chars = prefix.toCharArray();
            for (char currChar : chars) {
                if (node.containsKey(currChar)) {
                    node = node.get(currChar);
                } else {
                    return false;
                }
            }
            return true;
        }
        public TrieNode searchPrefix(String prefix) {
            TrieNode node = root;
            char[] chars = prefix.toCharArray();
            for (char currChar : chars) {
                if (node.containsKey(currChar)) {
                    node = node.get(currChar);
                } else {
                    return null;
                }
            }
            return node;
        }
    }
}
