namespace Poplar.Algorithm.WeekSix
{
    public class Trie
    {
        private readonly short _base;
        private readonly Trie[] _tries;
        private bool _isEndOfWord;

        public Trie()
        {
            this._base = (short)'a';
            this._tries = new Trie[26];
            this._isEndOfWord = false;
        }

        /** Inserts a word into the trie. */
        public void Insert(string word)
        {
            var tries = this._tries;
            for (int i = 0; i < word.Length; i++)
            {
                var c = word[i] - this._base;
                var trie = tries[c];
                if (trie == null)
                {
                    trie = new Trie();
                    tries[c] = trie;
                }
                if (i == word.Length - 1)
                {
                    trie._isEndOfWord = true;
                }
                tries = trie._tries;
            }
        }

        /** Returns if the word is in the trie. */
        public bool Search(string word)
        {
            var tries = this._tries;
            for (int i = 0; i < word.Length; i++)
            {
                var c = word[i] - this._base;
                var trie = tries[c];
                if (trie == null)
                {
                    return false;
                }
                if (i == word.Length - 1 && !trie._isEndOfWord)
                {
                    return false;
                }
                tries = trie._tries;
            }
            return true;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public bool StartsWith(string prefix)
        {
            var tries = this._tries;
            for (int i = 0; i < prefix.Length; i++)
            {
                var c = prefix[i] - this._base;
                var trie = tries[c];
                if (trie == null)
                {
                    return false;
                }
                if (i == prefix.Length - 1)
                {
                    return true;
                }
                tries = trie._tries;
            }
            return true;
        }
    }
}
