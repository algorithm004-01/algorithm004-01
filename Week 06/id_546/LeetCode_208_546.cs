using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 208. 实现 Trie (前缀树)
    /// </summary>

    class TrieNode
    {
        public char val;
        public bool isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode() { }
        public TrieNode(char c)
        {
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }

    public class Trie
    {
        private TrieNode root;
        public Trie()
        {
            root = new TrieNode();
            root.val = ' ';
        }

        public void Insert(String word)
        {
            TrieNode ws = root;
            for (int i = 0; i < word.Length; i++)
            {
                char c = word[i];
                if (ws.children[c - 'a'] == null)
                {
                    ws.children[c - 'a'] = new TrieNode(c);
                }
                ws = ws.children[c - 'a'];
            }
            ws.isWord = true;
        }

        public bool Search(String word)
        {
            TrieNode ws = root;
            for (int i = 0; i < word.Length; i++)
            {
                char c = word[i];
                if (ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return ws.isWord;
        }

        public bool StartsWith(String prefix)
        {
            TrieNode ws = root;
            for (int i = 0; i < prefix.Length; i++)
            {
                char c = prefix[i];
                if (ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return true;
        }
    }
}
