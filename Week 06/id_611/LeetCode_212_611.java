import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {
    private HashSet<String> set = new HashSet<>();
    private boolean[][] meno;
    private Trie trie;

    public List<String> findWords(char[][] board, String[] words) {
        meno = new boolean[board.length][];
        trie = new Trie();

        //初始化备忘录
        for(int i = 0; i < board.length; i++){
            meno[i] = new boolean[board[i].length];
        }

        //生成字典树
        for(int i = 0; i < words.length; i++){
            trie.insert(words[i]);
        }

        //dfs查找
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                dfs(board, row, col, "", trie);
            }
        }
        return new ArrayList<>(set);
    }

    public void dfs(char[][] board, int row, int col, String str, Trie trie){
        //终止条件
        if(row < 0 || col <0 || row >= board.length || col >= board[row].length || meno[row][col] )
            return;

        str += board[row][col];
        //匹配到前缀字符串
        if(!trie.startWith(str))
            return;
        
        meno[row][col] = true;
        if(trie.search(str))
            set.add(str);
            
        //上下左右查找匹配路径
        dfs(board, row - 1, col, str, trie);
        dfs(board, row + 1, col, str, trie);
        dfs(board, row, col - 1, str, trie);   
        dfs(board, row, col + 1, str, trie); 
        meno[row][col] = false;            
    }

}

class TreeNode{
    private final int SIZE = 26;
    private TreeNode children [];
    private boolean isEnd = false;

    public TreeNode(){
        children = new TreeNode[SIZE];
    }
    //判断是否有对应字符串
    public boolean containsKey(char key){
        return children[key - 'a'] != null;
    }

    //查询子树
    public TreeNode get(char key){
        return children[key - 'a'];
    }

    //插入子树
    public void put(char key,TreeNode sub){
        children[key-'a'] = sub;
    }

    //设为结束点
    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }

}

class Trie{
    TreeNode root;
    public Trie(){
        root = new TreeNode();
    }

    public void insert(String word){
        TreeNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                node.put(c, new TreeNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    //抽象出查找前缀的公有方法
    private TreeNode searchPrefix(String word){
        TreeNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                return null;
            }
            node = node.get(c);
        }
        return node;
    }

    public boolean search(String word){
        TreeNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startWith(String prefix){
        return searchPrefix(prefix) != null;
    }
}