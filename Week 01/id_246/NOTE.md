# NOTE

第一次系统接触数据结构和算法

第一周课程接触链表和跳表相关内容，用python实现了简单的链表结构

class ListNode:
     def __init__(self, x):
         self.val = x
         self.next = None

def create_linked_list(nums):
    if not nums:
        return
    head = prev = ListNode(nums[0])
    for num in nums[1:]:
        tmp = ListNode(num)
        prev.next = tmp
        prev = prev.next
    return head

def print_linked_list(head):
    nums = []
    while head:
        nums.append(head.val)
        head = head.next
        print(nums)
    return nums

head = create_linked_list([1,2,3,4,5,6,7,8,9])

print_linked_list(head)

接下来会补充其他数据结构的python实现