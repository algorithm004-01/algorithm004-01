#给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。 
#
# 如果不存在最后一个单词，请返回 0 。 
#
# 说明：一个单词是指由字母组成，但不包含任何空格的字符串。 
#
# 示例: 
#
# 输入: "Hello World"
#输出: 5
# 
# Related Topics 字符串



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        # trim all right spaces
        # split by space
        # get last part of len
        return len(s.rstrip().split(" ")[-1])

    def lengthOfLastWordII(self, s):
        """

        :param s:
        :type s:
        :return:
        :rtype:
        """
        # skip trailing space
        i = len(s) - 1
        while i >= 0 and s[i] == " ":
            i -= 1
        # iterate last word
        j = i
        while j >= 0 and s[j] != " ":
            j -= 1
        return i - j


        
#leetcode submit region end(Prohibit modification and deletion)
