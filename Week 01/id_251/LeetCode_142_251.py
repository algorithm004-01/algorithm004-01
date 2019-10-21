# 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
#
# 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
#
# 说明：不允许修改给定的链表。 
#
# 
#
# 示例 1： 
#
# 输入：head = [3,2,0,-4], pos = 1
# 输出：tail connects to node index 1
# 解释：链表中有一个环，其尾部连接到第二个节点。
# 
#
# 
#
# 示例 2： 
#
# 输入：head = [1,2], pos = 0
# 输出：tail connects to node index 0
# 解释：链表中有一个环，其尾部连接到第一个节点。
# 
#
# 
#
# 示例 3： 
#
# 输入：head = [1], pos = -1
# 输出：no cycle
# 解释：链表中没有环。
# 
#
# 
#
# 
#
# 进阶： 
# 你是否可以不用额外空间解决此题？
# Related Topics 链表 双指针


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

"""
1 哈希表
2 Floyd
"""


class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        visited = set()
        while head:
            if head in visited:
                return head
            else:
                visited.add(head)
                head = head.next

    #### 2 Floyd方法
    def slow_fast_index(self, head):
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return slow  # return meet position
        # 如果不写return python 会默认 return None

    def floyd(self, head):
        meet_position = self.slow_fast_index(head)
        if meet_position:
            while head != meet_position:
                head = head.next
                meet_position = meet_position.next
            return head

    # 2 Floyd优化
    def floyd1(self, head):
        slow = fast = head
        while True:
            if not (fast and fast.next):  # fast已到尾部 和 链表为空 都囊括了
                return None
            slow, fast = slow.next, fast.next.next
            if slow is fast:
                break
        while head != slow:
            head, slow = head.next, slow.next
        return head

# leetcode submit region end(Prohibit modification and deletion)
