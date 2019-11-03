# 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
#
# 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
#
# 
#
# 示例: 
#
# 给定 1->2->3->4, 你应该返回 2->1->4->3.
# 
# Related Topics 链表


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


"""
1 迭代法 pre --> a --> b --> b.next to pre --> b --> a --> b.next 同时修改，然后pre 移到 a
2 递归
    (1) 结束条件：后面已经反转的链表为空或者链表中只有一个元素 head = None or head.next = None
    (2) second = head.next 递推公式：head --> second --> f(second.next) to second --> head --> (second.next)
        ! head.next = f(second.next) # 调转完新的第二个结点，指向后面已经反转完的头结点
        !! second.next = head # 调转
        :return second # 返回新头结点
"""


class Solution(object):
    # 1 迭代法
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        pre, pre.next = self, head
        while pre.next and pre.next.next:
            a = pre.next
            b = a.next
            pre.next, b.next, a.next = b, a, b.next
            pre = a
        return self.next

    # 好理解
    def swapPairs1(self, head):
        dummy = pre = ListNode(0)
        pre.next = head
        while pre.next and pre.next.next:
            a = pre.next
            b = a.next
            pre.next, b.next, a.next = b, a, b.next
            pre = a
        return dummy.next

    # 2 递归
    def swapPairs2(self, head):
        if not head or not head.next:
            return head
        # head --> second --> f(second.next) to second --> head --> f(second.next)
        # 先head指向 f(second.next), 然后 second指向head 最后 返回 新头结点
        second = head.next
        head.next = self.swapPairs2(second.next)
        second.next = head
        return second
        # ======>
        # head.next, head, head.next = self.swapPairs2(head.next.next), head.next, head
        # return head

# leetcode submit region end(Prohibit modification and deletion)
