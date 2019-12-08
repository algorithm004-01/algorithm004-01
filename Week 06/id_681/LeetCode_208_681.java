class Trie {
    public boolean isWord;
    public char word;
    public Trie[] tries = new Trie[26];

    public Trie() {
        this.isWord = false;
        this.word = ' ';

    }

    public void insert(String word) {
        char[] array = word.toCharArray();
        Trie node = this;
        for (int i = 0; i < array.length; i++) {
            if (node.tries[array[i] - 'a'] == null) {
                node.tries[array[i] - 'a'] = new Trie();
            }
            node = node.tries[array[i] - 'a'];
            node.word = array[i];
            if (i == array.length - 1) {
                node.isWord = true;
            }
        }

    }

    public boolean search(String word) {
        char[] array = word.toCharArray();
        Trie node = this;
        for (int i = 0; i < array.length; i++) {
            if (node.tries[array[i] - 'a'] != null) {
                node = node.tries[array[i] - 'a'];
                if (node.word == array[i])
                    continue;
                else
                    return false;
            } else
                return false;

        }
        return node.isWord == true ? true : false;
    }

    public boolean startsWith(String prefix) {
        char[] array = prefix.toCharArray();
        Trie node = this;
        for (int i = 0; i < array.length; i++) {
            if (node.tries[array[i] - 'a'] != null) {
                node = node.tries[array[i] - 'a'];
                if (node.word == array[i])
                    continue;
                else
                    return false;
            } else
                return false;

        }
        return true;
    }
}
