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
    # 参考资料: https://www.cnblogs.com/kubixuesheng/p/4394509.html
    (1) 结束条件：已经反转的链表为空或者链表中只有一个元素 head = None or head.next = None
    (1) 递推公式：
        ! 先反转后面的链表，走到链表的末端结点 new_head = f(head.next),
        !! 再将当前节点设置为后面节点的后续节点 head.next.next = head; head.next = None
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
        # 或者
        # head = pre
        # return head

    def reverseList1(self, head):
        # 已经反转的链表为空或者链表中只有一个元素
        if head is None or head.next is None:
            return head
        # 先反转后面的链表，走到链表的末端结点
        new_head = self.reverseList1(head.next)
        # 再将当前节点设置为后面节点的后续节点
        head.next.next = head
        head.next = None
        return new_head  # 走到链表的末端结点
# leetcode submit region end(Prohibit modification and deletion)
