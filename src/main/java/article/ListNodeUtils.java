package article;

public class ListNodeUtils {

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
}
