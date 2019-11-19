package article.n30;

import article.ListNode;
import article.ListNodeUtils;

public class A025 {

	public static void main(String args[]) {
		System.out.println(ListNodeUtils.buildInfo(reverseKGroup(ListNodeUtils.buildNodes(1, 2, 3, 4, 5), 3)));
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		return reverseKGroup(null, head, null, k);

	}

	public static ListNode reverseKGroup(ListNode last, ListNode head, ListNode first, int size) {

		if (head == null) {
			return first;
		}

		// 判定size够不够， 不够的话， 保持原来的样子
		int count = 1;
		ListNode cur = head;
		while (count < size) {
			cur = cur.next;
			if (cur == null) {
				break;
			}
			count++;
		}

		if (count < size) {
			if (null == last) {
				return head;
			}
			last.next = head;
			return first;
		}
		count = 0;
		ListNode current = null;
		ListNode pre = null;
		ListNode end = null;
		while (count < size) {
			if (end == null) {
				end = head;
			}

			current = head;
			head = head.next;

			current.next = pre;
			pre = current;
			if (head == null) {
				break;
			}
			count++;
		}

		if (first == null) {
			first = current;
		}

		if (last != null) {
			last.next = current;
			last = end;
		} else {
			last = end;
		}
		return reverseKGroup(last, head, first, size);
	}
}
