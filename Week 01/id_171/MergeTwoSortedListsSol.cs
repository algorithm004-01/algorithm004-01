using Poplar.Algorithm.Models;

namespace Poplar.Algorithm.WeekOne
{
    /// <summary>
    /// 合并两个有序链表
    /// https://leetcode.com/problems/merge-two-sorted-lists/
    /// https://leetcode-cn.com/problems/merge-two-sorted-lists/
    /// </summary>
    public class MergeTwoSortedListsSol
    {
        public ListNode MergeTwoLists(ListNode l1, ListNode l2)
        {
            //return MergeTwoListsOne(l1, l2);
            return MergeTwoListTwo(l1, l2);
        }

        /// <summary>
        /// 递归
        /// </summary>
        /// <param name="l1"></param>
        /// <param name="l2"></param>
        /// <returns></returns>
        private ListNode MergeTwoListTwo(ListNode l1, ListNode l2)
        {
            if (l1 == null)
            {
                return l2;
            }
            if (l2 == null)
            {
                return l1;
            }
            if (l1.val <= l2.val)
            {
                l1.next = MergeTwoListTwo(l1.next, l2);
                return l1;
            }
            else
            {
                l2.next = MergeTwoListTwo(l2.next, l1);
                return l2;
            }
        }

        /// <summary>
        /// 迭代
        /// </summary>
        /// <param name="l1"></param>
        /// <param name="l2"></param>
        /// <returns></returns>
        private ListNode MergeTwoListsOne(ListNode l1, ListNode l2)
        {
            if (l1 == null)
            {
                return l2;
            }
            if (l2 == null)
            {
                return l1;
            }
            var head = new ListNode(-1);
            var prev = head;
            while (l1 != null && l2 != null)
            {
                if (l1.val <= l2.val)
                {
                    prev.next = l1;
                    l1 = l1.next;
                }
                else
                {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }
            prev.next = l1 == null ? l2 : l1;
            return head;
        }
    }
}
