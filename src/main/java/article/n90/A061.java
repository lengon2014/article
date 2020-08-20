package article.n90;

import article.ListNode;
import article.ListNodeUtils;

/**
 * 61. 旋转链表 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->4->5->NULL, k = 2 输出: 4->5->1->2->3->NULL 解释: 向右旋转 1 步:
 * 5->1->2->3->4->NULL 向右旋转 2 步: 4->5->1->2->3->NULL 示例 2:
 * 
 * 输入: 0->1->2->NULL, k = 4 输出: 2->0->1->NULL 解释: 向右旋转 1 步: 2->0->1->NULL 向右旋转 2
 * 步: 1->2->0->NULL 向右旋转 3 步: 0->1->2->NULL 向右旋转 4 步: 2->0->1->NULL
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A061 {

	public static void main(String args[]) {
		ListNode head = ListNodeUtils.buildNodes(1, 2, 3, 4,5);
		A061 a = new A061();
		System.out.println(ListNodeUtils.buildInfo(a.rotateRight(head, 6)));
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		// 先计算出size
		ListNode first = head;
		int size = 1;

		// 获得tail
		ListNode tail = null;
		while (first.next != null) {
			size++;
			first = first.next;
			tail = first;
		}

		// 刚好是倍数关系
		if (k % size == 0) {
			return head;
		} else {
			k = k % size;
		}

		// 如果小于， 那么进行要进行标记的就只有一个head
		int nowIndex = 1;
		first = head;
		while (head.next != null) {
			if (nowIndex == size - k) {
				// next作为一个head
				ListNode next = head.next;
				tail.next = first;
				head.next = null;
				// 将标记最开始的节点
				return next;
			}
			nowIndex++;
			head = head.next;
		}
		return null;
	}
}
