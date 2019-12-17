#### String
##### reference
[are your strings immutable](https://lemire.me/blog/2017/07/07/are-your-strings-immutable/)
[Atoi sample code](https://shimo.im/docs/KkDKkpWxjjrJXdpY/read)
```angular2html
    def myAtoi(self, s):

        if len(s) == 0 : return 0
        ls = list(s.strip())
        
        sign = -1 if ls[0] == '-' else 1

        if ls[0] in ['-','+'] : del ls[0]

        ret, i = 0, 0

        while i < len(ls) and ls[i].isdigit() :
            ret = ret*10 + ord(ls[i]) - ord('0')
            i += 1

        return max(-2**31, min(sign * ret,2**31-1))
```
##### basic
`#` | leetcode-cn | leetcode | solution
---:|:----|:----|:----
58 | [最后一个单词的长度](https://leetcode-cn.com/problems/length-of-last-word/) | [length-of-last-word](https://leetcode.com/problems/length-of-last-word/) | [python]([58]最后一个单词的长度.py)
709| [转换成小写字母](https://leetcode-cn.com/problems/to-lower-case/) | [to-lower-case](https://leetcode.com/problems/to-lower-case/)
771 | [宝石与石头](https://leetcode-cn.com/problems/jewels-and-stones/) | [jewels-and-stones](https://leetcode.com/problems/jewels-and-stones/)
387 | [字符串中的第一个唯一字符](https://leetcode-cn.com/problems/first-unique-character-in-a-string/) | [first-unique-character-in-a-string](https://leetcode-cn.com/problems/first-unique-character-in-a-string/)
8 | [字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/) | [string-to-integer-atoi](https://leetcode-cn.com/problems/string-to-integer-atoi/)
##### operation
`#` | leetcode-cn | leetcode |
---:|:----|:----|
14 | [最长公共前缀](https://leetcode-cn.com/problems/longest-common-prefix/) | [longest-common-prefix](https://leetcode.com/problems/longest-common-prefix/)
344 | [反转字符串](https://leetcode-cn.com/problems/reverse-string) | [reverse-string](https://leetcode.com/problems/reverse-string)
541 | [反转字符串 II](https://leetcode-cn.com/problems/reverse-string-ii/) | [reverse-string-ii](https://leetcode.com/problems/reverse-string-ii/)
151 | [翻转字符串里的单词](https://leetcode-cn.com/problems/reverse-words-in-a-string/) | [reverse-words-in-a-string](https://leetcode.com/problems/reverse-words-in-a-string/)
557 | [反转字符串中的单词 III](https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/) | [reverse-words-in-a-string-iii](https://leetcode.com/problems/reverse-words-in-a-string-iii/)
917 | [仅仅反转字母](https://leetcode-cn.com/problems/reverse-only-letters/) | [reverse-only-letters](https://leetcode.com/problems/reverse-only-letters/)
##### anagram
`#` | leetcode-cn | leetcode |
---:|:----|:----|
242 | [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/) | [valid-anagram](https://leetcode.com/problems/valid-anagram/)
49 | [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/) | [group-anagrams](https://leetcode.com/problems/group-anagrams/)
438 | [找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/) | [find-all-anagrams-in-a-string](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
##### palindrome
`#` | leetcode-cn | leetcode |
---:|:----|:----|
125 | [验证回文串](https://leetcode-cn.com/problems/valid-palindrome/) | [valid-palindrome](https://leetcode.com/problems/valid-palindrome/)
680 | [验证回文字符串 Ⅱ](https://leetcode-cn.com/problems/valid-palindrome-ii/) | [valid-palindrome-ii](https://leetcode.com/problems/valid-palindrome-ii/)
5 | [最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/) | [longest-palindromic-substring](https://leetcode.com/problems/longest-palindromic-substring/)

##### subsequence + DP
[正则表达式匹配 详解](https://leetcode-cn.com/problems/regular-expression-matching/solution/ji-yu-guan-fang-ti-jie-gen-xiang-xi-de-jiang-jie-b/)

`#` | leetcode-cn | leetcode
---:|:----|:----
1143 | [最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/) | [longest-common-subsequence](https://leetcode.com/problems/longest-common-subsequence/)
72 | [编辑距离](https://leetcode-cn.com/problems/edit-distance/) | [edit-distance](https://leetcode.com/problems/edit-distance/)
10 | [正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/) | [regular-expression-matching](https://leetcode.com/problems/regular-expression-matching/)
44 | [通配符匹配](https://leetcode-cn.com/problems/wildcard-matching/) | [wildcard-matching](https://leetcode.com/problems/wildcard-matching/)
115 | [不同的子序列](https://leetcode-cn.com/problems/distinct-subsequences/) | [distinct-subsequences](https://leetcode.com/problems/distinct-subsequences/)

##### KMP
[字符串匹配之KMP、BoyerMoore、Sunday算法](https://blog.csdn.net/u012505432/article/details/52210975)

[字符串匹配暴力法代码示例](https://shimo.im/docs/dQDxQW8yXPXxh3Hg/read)

[Rabin-Karp 代码示例](https://shimo.im/docs/KXDdkT99TVtXvTXP/read)

[字符串匹配的KMP算法](http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html)

[KMP字符串匹配算法1](https://www.bilibili.com/video/av11866460?from=search&seid=17425875345653862171)