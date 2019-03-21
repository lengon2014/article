package article.n100;

public class A019 {

	public static void main(String args[]) {
		System.out.println(buildInfo(removeNthFromEnd(buildNodes(new int[] { 1, 2,3 }), 5)));
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

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int nowSize = 1;

		ListNode preNode = null;
		ListNode removeNode = head;
		ListNode cur = head;
		while (cur.next != null) {
			if (nowSize < n) {
				nowSize++;
			} else if (n == nowSize) {
				if (null == preNode) {
					preNode = head;
				} else {
					preNode = preNode.next;
				}
				removeNode = removeNode.next;

			}
			cur = cur.next;
		}
		if (nowSize < n) {
			return head;
		}
		if (null == preNode) {
			return head.next;
		}

		preNode.next = removeNode.next;
		return head;
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
}
