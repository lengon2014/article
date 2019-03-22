package article.n100;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * @author lengon
 *
 */
public class A024 {

	public static void main(String args[]) {
		System.out.println(ListNodeUtils.buildInfo(swapPairs(null)));
	}

	public static ListNode swapPairs(ListNode head) {
		ListNode first = null;
		ListNode nextNode = null;
		while (head != null && head.next != null) {
			if (first == null) {
				ListNode next = head.next.next;
				first = head.next;
				head.next = null;
				first.next = head;
				nextNode = head;
				if (next != null) {
					head.next = next;
				}
				head = next;
				continue;
			}

			ListNode nextPair = head.next.next;
			nextNode.next = head.next;
			head.next = null;
			nextNode.next.next = head;
			nextNode = head;
			head = nextPair;
		}

		if (head != null) {
			if (first == null) {
				first = head;
			} else {
				nextNode.next = head;
			}
		}
		return first;
	}
}
