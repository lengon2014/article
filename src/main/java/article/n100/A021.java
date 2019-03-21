package article.n100;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 * 
 * @author lengon
 *
 */
public class A021 {

	public static void main(String args[]) {
		System.out.println(ListNodeUtils
				.buildInfo(mergeTwoLists(ListNodeUtils.buildNodes(1), ListNodeUtils.buildNodes(2))));
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode first = null;
		ListNode head = null;
		boolean isFirst = true;
		while (l1 != null || l2 != null) {
			if (l1 == null || (l1!=null && l2!=null && l1.val > l2.val)) {
				isFirst = false;
			}

			if (l2 == null || (l1!=null && l2!=null &&l1.val < l2.val)) {
				isFirst = true;
			}

			if (isFirst) {
				if (null == first) {
					first = l1;
					head = l1;
				} else {
					first.next = new ListNode(l1.val);
					first = first.next;
				}
				l1 = l1.next;
				isFirst = false;
			} else {
				if (null == first) {
					first = l2;
					head = l2;
				} else {
					first.next = new ListNode(l2.val);
					first = first.next;
				}
				l2 = l2.next;
				isFirst = true;
			}
		}

		return head;
	}
}
