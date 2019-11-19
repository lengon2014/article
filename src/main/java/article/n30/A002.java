package article.n30;

import article.ListNode;

public class A002 {

	public static void main(String args[]) {
		ListNode l1 = buildNodes(1, 8);
		ListNode l2 = buildNodes(0);
		System.out.println(buildInfo(build(l1, l2)));
	}

	public static ListNode buildNodes(int... inputs) {
		ListNode first = null;
		ListNode pre = null;
		for (int input : inputs) {
			if (first == null) {
				first = new ListNode(input);
				pre = first;
			} else {
				ListNode now = new ListNode(input);
				pre.next = now;
				pre = now;
			}
		}
		return first;
	}

	public static String buildInfo(ListNode node) {
		StringBuilder sb = new StringBuilder();
		while (true) {
			sb.append(node.val);
			if (node.next == null) {
				return sb.toString();
			} else {
				node = node.next;
				sb.append(" -> ");
			}
		}
	}

	public static ListNode build(ListNode l1, ListNode l2) {
		// 进位
		int tenNumber = 0;
		ListNode first = null;
		ListNode pre = null;
		while (true) {
			int l1Value = 0;
			int l2Value = 0;
			if (l1 != null) {
				l1Value = l1.val;
			}

			if (l2 != null) {
				l2Value = l2.val;
			}

			int sum = l1Value + l2Value + tenNumber;

			if (sum >= 10) {
				tenNumber = 1;
				sum = sum - 10;
			} else {
				tenNumber = 0;
			}

			ListNode node = new ListNode(sum);
			if (pre == null) {
				first = node;
			} else {
				pre.next = node;
			}
			pre = node;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
			if (l1 == null && l2 == null) {
				if (tenNumber > 0) {
					ListNode last = new ListNode(tenNumber);
					pre.next = last;
				}

				return first;
			}
		}
	}
}
