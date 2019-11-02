//
// Created by mac on 2019/10/28.
//

// 有效的字母异位词
//
// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
// 输出: true
// 示例 2:
//
// 输入: s = "rat", t = "car"
// 输出: false
// 说明:
// 你可以假设字符串只包含小写字母。
//
// 进阶:
// 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
//
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/valid-anagram
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

// 用了两种方法

// 执行用时: 12 ms, 在所有 cpp 提交中击败了 84.76% 的用户
class SolutionV1 {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) {
            return false;
        }

        // todo: 复习 string 容器的使用
        unordered_map<char, int> mem;

        for (char i : s)
            mem[i]++;

        for (char i : t)
            mem[i]--;

        // todo: 复习迭代器的使用
        for (auto & iter : mem) {
            if (iter.second != 0)
                return false;
        }

        return true;
    }
};

// 执行用时: 8 ms, 在所有 cpp 提交中击败了 97.50% 的用户
class SolutionV2 {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) {
            return false;
        }
        int table[26] = {0};

        for (char i : s) {
            table[i - 'a']++;
        }
        for (char i : t) {
            table[i - 'a']--;
            if (table[i - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
};
