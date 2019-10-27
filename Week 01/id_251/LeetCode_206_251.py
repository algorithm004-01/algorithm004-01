# 反转一个单链表。
#
# 示例: 
#
# 输入: 1->2->3->4->5->NULL
# 输出: 5->4->3->2->1->NULL
#
# 进阶: 
# 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
# Related Topics 链表


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
"""
1 迭代
2 递归
    (1) 结束条件：已经反转的链表为空或者链表中只有一个元素 head = None or head.next = None
    (2) 递推公式：只要画一下第一层就行head
        ! 先反转后面的链表，记录头结点 new_pre = f(head.next),
        !! 反转当前节点 head.next.next = head; head.next = None
"""


class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        pre, curr = None, head
        while curr:
            curr.next, pre, curr = pre, curr, curr.next
        return pre

    def reverseList1(self, head):
        # 已经反转的链表为空或者链表中只有一个元素
        # not head or not head.next ==== head is None or head.next is None
        if not (head and head.next):
            return head
        # 先反转后面的链表，记录头结点
        new_pre = self.reverseList1(head.next)
        # 反转当前节点
        head.next.next, head.next = head, None
        return new_pre  # 返回反转好部分的头结点
