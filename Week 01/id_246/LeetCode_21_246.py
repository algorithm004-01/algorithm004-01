'''
merge two sorted lists

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
'''

#迭代
l1 = create_linked_list([1,2,3,4,5])
l2 = create_linked_list([6,7,8,9,10])

def mergeTwoLists_1(l1, l2) :
    # maintain an unchanging reference to node ahead of the return node.
    prehead = ListNode(-1)
    prev = prehead
    while l1 and l2:
        if l1.val <= l2.val:
            prev.next = l1
            l1 = l1.next
        else:
            prev.next = l2
            l2 = l2.next
        prev = prev.next
    # the non-null list to the end of the merged list.
    prev.next = l1 if l1 is not None else l2
    return prehead.next


# 递归
def mergeTwoLists_2(l1,l2):
    if l1 is None:
        return l2
    elif l2 is None:
        return l1
    elif l1.val < l2.val:
        l1.next = mergeTwoLists_2(l1.next,l2)
        return l1
    else:
        l2.next = mergeTwoLists_2(l1, l2.next)
        return l2