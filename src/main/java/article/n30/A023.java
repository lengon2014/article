package article.n30;

import java.util.Arrays;

import article.ListNode;
import article.ListNodeUtils;

/**
 * 23. Merge k Sorted Lists Hard
 * 
 * 2160
 * 
 * 136
 * 
 * Favorite
 * 
 * Share Merge k sorted linked lists and return it as one sorted list. Analyze
 * and describe its complexity.
 * 
 * Example:
 * 
 * Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
 * 
 * @author lengon
 *
 */
public class A023 {
	public static void main(String args[]) {
		System.out.println(ListNodeUtils
				.buildInfo(mergeKLists(new ListNode[] { ListNodeUtils.buildNodes(1), ListNodeUtils.buildNodes(2) })));
	}

	public static ListNode mergeKLists(ListNode[] lists) {

		ListNode node = null;
		ListNode head = null;
		while (true) {

			ListNode min = null;
			int index = 0;
			for (int i = 0; i < lists.length; i++) {
				ListNode l = lists[i];
				if (l == null) {
					continue;
				}

				if (min == null || l.val < min.val) {
					min = l;
					index = i;
				}
			}

			if (null == min) {
				break;
			}

			if (null == node) {
				node = new ListNode(min.val);
				head = node;
			} else {
				node.next = new ListNode(min.val);
				node = node.next;
			}
			min = min.next;
			lists[index] = min;
		}
		return head;
	}
}
