# 学习总结

## 高级DP

复杂度来源：
状态拥有更多的维度（二维、三维、或者更多、甚至需要压缩）
状态方程更加复杂

## 字符串算法

- 暴力法
- Rabin-karp 算法
- KMP算法

参考链接

    不可变字符串 https://lemire.me/blog/2017/07/07/are-your-strings-immutable/
    Atoi 代码示例 https://shimo.im/docs/KkDKkpWxjjrJXdpY/read

```java
public int myAtoi(String str) {
    int index = 0, sign = 1, total = 0;
    //1. Empty string
    if(str.length() == 0) return 0;

    //2. Remove Spaces
    while(str.charAt(index) == ' ' && index < str.length())
        index ++;

    //3. Handle signs
    if(str.charAt(index) == '+' || str.charAt(index) == '-'){
        sign = str.charAt(index) == '+' ? 1 : -1;
        index ++;
    }

    //4. Convert number and avoid overflow
    while(index < str.length()){
        int digit = str.charAt(index) - '0';
        if(digit < 0 || digit > 9) break;

        //check if total will be overflow after 10 times and add digit
        if(Integer.MAX_VALUE/10 < total ||
        	Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        total = 10 * total + digit;
        index ++;
    }
    return total * sign;
}
```

```python
class Solution(object):

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

字符串基础问题

    https://leetcode-cn.com/problems/to-lower-case/
    https://leetcode-cn.com/problems/length-of-last-word/
    https://leetcode-cn.com/problems/jewels-and-stones/
    https://leetcode-cn.com/problems/first-unique-character-in-a-string/
    https://leetcode-cn.com/problems/string-to-integer-atoi/

字符串操作问题

    https://leetcode-cn.com/problems/longest-common-prefix/description/
    https://leetcode-cn.com/problems/reverse-string
    https://leetcode-cn.com/problems/reverse-string-ii/
    https://leetcode-cn.com/problems/reverse-words-in-a-string/
    https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
    https://leetcode-cn.com/problems/reverse-only-letters/

异位词问题

    https://leetcode-cn.com/problems/valid-anagram/
    https://leetcode-cn.com/problems/group-anagrams/
    https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/

回文串问题

    https://leetcode-cn.com/problems/valid-palindrome/
    https://leetcode-cn.com/problems/valid-palindrome-ii/
    https://leetcode-cn.com/problems/longest-palindromic-substring/


最长子串、子序列问题

    https://leetcode-cn.com/problems/longest-common-subsequence/
    https://leetcode-cn.com/problems/edit-distance/
    https://leetcode-cn.com/problems/longest-palindromic-substring/

字符串 +DP 问题

    https://leetcode-cn.com/problems/regular-expression-matching/
    https://leetcode-cn.com/problems/regular-expression-matching/solution/ji-yu-guan-fang-ti-jie-gen-xiang-xi-de-jiang-jie-b/
    https://leetcode-cn.com/problems/wildcard-matching/
    https://leetcode-cn.com/problems/distinct-subsequences/


参考链接

    Boyer-Moore 算法 http://xn--https-ni33a//www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html
    Sunday 算法 https://blog.csdn.net/u012505432/article/details/52210975
    字符串匹配暴力法代码示例 https://shimo.im/docs/dQDxQW8yXPXxh3Hg/read
```
public static int forceSearch(String txt, String pat) {
    int M = txt.length();
    int N = pat.length();

    for (int i = 0; i <= M - N; i++) {
        int j;
        for (j = 0; j < N; j++) {
            if (txt.charAt(i + j) != pat.charAt(j))
                break;
        }
        if (j == N) {
            return i;
        }
        // 更加聪明？ 
        // 1. 预先判断 hash(txt.substring(i, M)) == hash(pat)
        // 2. KMP 
    }
    return -1;
}
```
    Rabin-Karp 代码示例
```
public final static int D = 256;
public final static int Q = 9997;

static int RabinKarpSerach(String txt, String pat) {
    int M = pat.length();
    int N = txt.length();
    int i, j;
    int patHash = 0, txtHash = 0;

    for (i = 0; i < M; i++) {
        patHash = (D * patHash + pat.charAt(i)) % Q;
        txtHash = (D * txtHash + txt.charAt(i)) % Q;
    }

    int highestPow = 1;  // pow(256, M-1)
    for (i = 0; i < M - 1; i++) 
        highestPow = (highestPow * D) % Q;

    for (i = 0; i <= N - M; i++) { // 枚举起点
        if (patHash == txtHash) {
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            }
            if (j == M)
                return i;
        }
        if (i < N - M) {
            txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + M)) % Q;
            if (txtHash < 0)
                txtHash += Q;
        }
    }

    return -1;
}
```
    KMP 字符串匹配算法视频 	https://www.bilibili.com/video/av11866460?from=search&seid=17425875345653862171
    字符串匹配的 KMP 算法 http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html

课后作业

    https://leetcode-cn.com/problems/first-unique-character-in-a-string/
    https://leetcode-cn.com/problems/string-to-integer-atoi/
    https://leetcode-cn.com/problems/reverse-string-ii/
    https://leetcode-cn.com/problems/reverse-words-in-a-string/
    https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
    https://leetcode-cn.com/problems/reverse-only-letters/
    https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
    https://leetcode-cn.com/problems/longest-palindromic-substring/
    https://leetcode-cn.com/problems/isomorphic-strings/
    https://leetcode-cn.com/problems/valid-palindrome-ii/
    https://leetcode-cn.com/problems/wildcard-matching
    https://leetcode-cn.com/problems/longest-valid-parentheses
    https://leetcode-cn.com/problems/distinct-subsequences/

