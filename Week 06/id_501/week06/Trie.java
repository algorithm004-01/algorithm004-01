package homework.week06;

import java.util.LinkedList;

/**
 * 实现Trie字典树
 * @author tangxy
 * @date 2019-11-24
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("helloworld");
        trie.insert("hellotree");
        System.out.println(trie.search("hello"));
        System.out.println(trie.startsWith("hello2"));
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        // 已存在，不插入
        if(search(word)){
            return;
        }
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode child = current.subNode(word.charAt(i));
            if(child != null){
                current = child;
            }else {
                current.childList.add(new TrieNode(word.charAt(i)));
                current = current.subNode(word.charAt(i));
            }
            current.count ++ ;
        }
        current.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if(current.subNode(word.charAt(i)) == null){
                return false;
            }else{
                current = current.subNode(word.charAt(i));
            }
        }
        if(current.isEnd){
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            if(current.subNode(prefix.charAt(i)) == null){
                return false;
            }else{
                current = current.subNode(prefix.charAt(i));
            }
        }
        return true;
    }

    /**
     * 删除字符串
     * @param word
     */
    public void deleteWord(String word){
        if(!search(word)){
            return;
        }
        TrieNode current = root;
        for(char c : word.toCharArray()){
            TrieNode child = current.subNode(c);
            if(child.count == 1){
                current.childList.remove(child);
                return;
            }else {
                child.count --;
                current = child;
            }
        }
        current.isEnd = false;
    }

    class TrieNode {
        /**
         * 内容
         */
        char content;
        /**
         * 是否是最后
         */
        boolean isEnd;
        /**
         * 统计
         */
        int count;
        /**
         * 子树
         */
        LinkedList<TrieNode> childList;

        public TrieNode(char content) {
            this.content = content;
            this.isEnd = false;
            this.count = 0;
            this.childList = new LinkedList<>();
        }

        public TrieNode subNode(char c){
            if(childList != null){
                for (TrieNode trieNode : childList) {
                    if(trieNode.content == c){
                        return  trieNode;
                    }
                }
            }
            return null;
        }

    }

}
