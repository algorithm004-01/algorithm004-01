package week06;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FindWords212 {

	public List<String> findWords(char[][] board, String[] words) {

		WordTrie myTrie = new WordTrie();
		TrieNode212 root = myTrie.root;
		for (String s : words) {
			myTrie.insert(s);
		}
		Set<String> result = new HashSet<>();
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				find(board, visited, i, j, m, n, result, root);
			}
		}
		System.out.println(result);
		return new LinkedList<String>(result);
	}

	private void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> result,
			TrieNode212 node) {

		if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
			return;
		}
		node = node.child[board[i][j] - 'a'];
		visited[i][j] = true;
		if (node == null) {
			visited[i][j] = false;
			return;
		}
		if (node.isEnd) {
			result.add(node.val);
		}
		find(board, visited, i + 1, j, m, n, result, node);
		find(board, visited, i, j + 1, m, n, result, node);
		find(board, visited, i, j - 1, m, n, result, node);
		find(board, visited, i - 1, j, m, n, result, node);

		visited[i][j] = false;

	}
}

class WordTrie {
	public TrieNode212 root = new TrieNode212();

	public void insert(String word) {
		TrieNode212 node = root;
		for (char ch : word.toCharArray()) {
			if (node.child[ch - 'a'] == null) {
				node.child[ch - 'a'] = new TrieNode212();
				node = node.child[ch - 'a'];
			} else {
				node = node.child[ch - 'a'];
			}
		}
		node.isEnd = true;
		node.val = word;
	}
}

class TrieNode212 {

	public String val;
	public TrieNode212[] child = new TrieNode212[26];
	public boolean isEnd = false;

	public TrieNode212() {

	}

}
