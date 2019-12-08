package week06;

class TrieNode {
	private TrieNode[] links;
	private final int R = 26;
	private boolean isEnd;

	public TrieNode() {
		links = new TrieNode[R];
	}

	public boolean containskey(char ch) {
		return links[ch - 'a'] != null;
	}

	public TrieNode get(char ch) {
		return links[ch - 'a'];
	}

	public void put(char ch, TrieNode node) {
		links[ch - 'a'] = node;
	}

	public void setEnd() {
		isEnd = true;
	}

	public boolean isEnd() {
		return isEnd;
	}
}

public class Trie208 {

	private TrieNode root;

	public Trie208() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!node.containskey(ch)) {
				node.put(ch, new TrieNode());
			}
			node = node.get(ch);
		}
		node.setEnd();
	}

	public boolean search(String word) {
		TrieNode node = searchprefix(word);
		return node != null && node.isEnd();
	}

	private TrieNode searchprefix(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (node.containskey(ch)) {
				node = node.get(ch);
			} else {
				return null;
			}
		}
		return node;
	}

	public boolean startwith(String prefix) {
		TrieNode node = searchprefix(prefix);
		return node != null;
	}
}
