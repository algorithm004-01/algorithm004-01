class Trie {
    TreeNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = root;
        for( int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!node.containsKey(c))
                node.put(c, new TreeNode());
            node = node.get(c);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode treeNode = searchPrefix(word);
        return treeNode != null && treeNode.isEnd();
    }

    public TreeNode searchPrefix(String word){
        TreeNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.containsKey(c))
                node = node.get(c);
            else
                return null;
        }
        return node;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}

class TreeNode{
    private int size = 26;
    private TreeNode children [];
    private boolean isEnd = false;

    public TreeNode(){
        children = new TreeNode[size];
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