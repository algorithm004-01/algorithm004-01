using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 127. 单词接龙
    /// </summary>
    public class WordLadder
    {


        public int LadderLength(String beginWord, String endWord, IList<string> wordList)
        {
            if (!wordList.Contains(endWord)) return 0;

            HashSet<string> beginSet = new HashSet<string>(), endSet = new HashSet<string>();

            int len = 1;
            int strLen = beginWord.Length;
            HashSet<string> visited = new HashSet<string>();

            beginSet.Add(beginWord);
            endSet.Add(endWord);
            while (beginSet.Any() && endSet.Any())
            {
                if (beginSet.Count > endSet.Count)
                {
                    HashSet<string> set = beginSet;
                    beginSet = endSet;
                    endSet = set;
                }

                HashSet<string> temp = new HashSet<string>();
                foreach (string word in beginSet)
                {
                    char[] chs = word.ToCharArray();

                    for (int i = 0; i < chs.Length; i++)
                    {
                        for (char c = 'a'; c <= 'z'; c++)
                        {
                            char old = chs[i];
                            chs[i] = c;
                            String target =new string( chs);

                            if (endSet.Contains(target))
                            {
                                return len + 1;
                            }

                            if (!visited.Contains(target) && wordList.Contains(target))
                            {
                                temp.Add(target);
                                visited.Add(target);
                            }
                            chs[i] = old;
                        }
                    }
                }

                beginSet = temp;
                len++;
            }

            return 0;
        }



        public int LadderLength2(string beginWord, string endWord, IList<string> wordList)
        {
           // IList<string> dict = new List<string>(wordList);
            IList<string> qs = new List<string>();
            IList<string> qe = new List<string>();
            IList<string> vis = new List<string>();
            
            qs.Add(beginWord);

            if (wordList.Contains(endWord))
                qe.Add(endWord); 

            for (int len = 2; qs.Any(); len++)
            {
                List<string> nq = new List<string>();
                foreach (string w in qs)
                {
                    for (int j = 0; j < w.Length; j++)
                    {
                        char[] ch = w.ToCharArray();
                        for (char c = 'a'; c <= 'z'; c++)
                        {
                            if (c == w[j]) 
                                continue; 

                            ch[j] = c;
                            string nb = new string(ch);

                            if (qe.Contains(nb)) 
                                return len;
                            if (wordList.Contains(nb))
                            {
                                vis.Add(nb);
                                nq.Add(nb);
                            }
                        }
                    }
                }
                qs = (nq.Count() < qe.Count()) ? nq : qe;
                qe = (qs == nq) ? qe : nq;
            }
            return 0;
        }


    }
}
