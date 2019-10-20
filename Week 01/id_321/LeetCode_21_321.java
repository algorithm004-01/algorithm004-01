package week01;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

// 1.µÝ¹é
// 2.µü´ú
public class MergeTwoLists21 {

	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head;
		if (l1.val < l2.val) {
			head = l1;
			head.next = mergeTwoLists1(l1.next, l2);
		} else {
			head = l2;
			head.next = mergeTwoLists1(l1, l2.next);
		}
		return head;
	}

	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

		ListNode prehead = new ListNode(-1);

		ListNode prev = prehead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}

		prev.next = l1 == null ? l2 : l1;

		return prehead.next;
	}

}
