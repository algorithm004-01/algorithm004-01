class Trie {
    private TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
    TreeNode node = root;
    for(int i = 0; i < word.length(); ++i) {
        if (!node.isContains(word.charAt(i)))
            node.putTreeNode(word.charAt(i), new TreeNode());
        node = node.getTreeNode(word.charAt(i));
    }
    node.setEnd();
}

public boolean search(String word) {
    TreeNode node = root;
    for(int i = 0; i < word.length(); ++i) {
        if (node.getTreeNode(word.charAt(i)) == null)
            return false;
        node = node.getTreeNode(word.charAt(i));
    }
    return node.isEnd();
}

/** Returns if there is any word in the trie that starts with the given prefix. */
public boolean startsWith(String prefix) {
    TreeNode node = root;
    for(int i = 0; i < prefix.length(); ++i) {
        if (node.getTreeNode(prefix.charAt(i)) == null)
            return false;
        node = node.getTreeNode(prefix.charAt(i));
    }
    return true;
}
}


class TreeNode {
    private TreeNode[] links;
    private final int SIZE = 26;
    private boolean isEnd;

    public TreeNode(){
        links = new TreeNode[SIZE];
    }

    public boolean isContains(char ch) {
        return links[ch - 'a'] != null;
    }

    public TreeNode getTreeNode(char ch) {
        return links[ch - 'a'];
    }

    public void putTreeNode(char ch, TreeNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}