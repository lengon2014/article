package article.n60;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0 输出: 4 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3 输出: -1
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A033 {
	public static void main(String args[]) {
		A033 a33 = new A033();
		System.out.print(a33.search(new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 1 }, 9));
	}

	public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		Node root = new Node(0, nums.length - 1);
		return isIn(root, target, nums);
	}

	// 进行2分查找
	public class Node {
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}

		int start;
		int end;
		Node left;
		Node right;
	}

	public void divice(Node node) {
		int size = node.end - node.start + 1;
		int center = node.start + size / 2;
		Node left = new Node(node.start, center);
		Node right = new Node(center + 1, node.end);
		node.left = left;
		node.right = right;
	}

	public int isIn(Node node, int target, int nums[]) {
		// 如果大于， 那么进行继续拆分
		if (node.end - node.start > 2) {
			divice(node);
			Node left = node.left;

			// 如果是升序
			if (nums[left.start] <= nums[left.end] && target >= nums[left.start] && target <= nums[left.end]) {
				return isIn(left, target, nums);
			}

			// 如果是降序
			if (nums[left.start] >= nums[left.end] && (target >= nums[left.start] || target <= nums[left.end])) {
				return isIn(left, target, nums);
			}

			Node right = node.right;
			// 如果是升序
			if (nums[right.start] <= nums[right.end] && target >= nums[right.start] && target <= nums[right.end]) {
				return isIn(right, target, nums);
			}

			// 如果是降序
			if (nums[right.start] >= nums[right.end] && (target >= nums[right.start] || target <= nums[right.end])) {
				return isIn(right, target, nums);
			}

			return -1;
		}

		if (nums[node.start] == target) {
			return node.start;
		}

		if (node.start + 1 < nums.length) {
			if (nums[node.start + 1] == target) {
				return node.start + 1;
			}
		}

		if (nums[node.end] == target) {
			return node.end;
		}

		return -1;
	}
}
