# 给定一个链表，判断链表中是否有环。
#
# 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
#
# 
#
# 示例 1： 
#
# 输入：head = [3,2,0,-4], pos = 1
# 输出：true
# 解释：链表中有一个环，其尾部连接到第二个节点。
# 
#
# 
#
# 示例 2： 
#
# 输入：head = [1,2], pos = 0
# 输出：true
# 解释：链表中有一个环，其尾部连接到第一个节点。
# 
#
# 
#
# 示例 3： 
#
# 输入：head = [1], pos = -1
# 输出：false
# 解释：链表中没有环。
# 
#
# 
#
# 
#
# 进阶： 
#
# 你能用 O(1)（即，常量）内存解决此问题吗？ 
# Related Topics 链表 双指针


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

"""
提示不要看官方这个head 等于一个list 的举例，严重误导人，看图就行了。
# 输入：head = [1,2], pos = 0
# 输出：true
1 哈希表
2 快慢指针法 很巧妙 记住就行
"""


class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        hash_set = set()
        while head:
            if head in hash_set:
                return True
            else:
                hash_set.add(head)
                head = head.next
        return False

    # 快慢指针法
    def hasCycleSlowFastIndex(self, head):
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        return False

# leetcode submit region end(Prohibit modification and deletion)
