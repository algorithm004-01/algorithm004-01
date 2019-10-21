# 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
#
# k 是一个正整数，它的值小于或等于链表的长度。 
#
# 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
#
# 示例 : 
#
# 给定这个链表：1->2->3->4->5 
#
# 当 k = 2 时，应当返回: 2->1->4->3->5 
#
# 当 k = 3 时，应当返回: 3->2->1->4->5 
#
# 说明 : 
#
# 
# 你的算法只能使用常数的额外空间。 
# 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
# 
# Related Topics 链表


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

"""
1 看图 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
"""

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        pre, end, pre.next, end.next = self, self, head, head

        while end:
            for i in range(k):
                if end is None:
                    break
                end = end.next
            if end is None:
                break
            start, _next, end.next = pre.next, end.next, None
            pre.next, start.next = self.reverse(start), _next
            end = pre = start
        return self.next

    def reverse(self, head):
        pre, curr = None, head
        while curr:
            curr.next, pre, curr = pre, curr, curr.next
        return pre

# leetcode submit region end(Prohibit modification and deletion)
