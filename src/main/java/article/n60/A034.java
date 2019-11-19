package article.n60;

import article.ArrayUtils;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8 输出: [3,4] 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6 输出: [-1,-1]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A034 {
	public static void main(String args[]) {
		A034 a = new A034();
		System.out.print(ArrayUtils.buildInfo(a.searchRange(new int[] { 5, 7, 7, 8, 8, 8, 10 }, 8)));
	}

	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[] { -1, -1 };
		}
		Result r = new Result();
		r.min = -1;
		r.max = -1;
		Node root = new Node(0, nums.length - 1);
		isIn(root, target, nums, r);
		return new int[] { r.min, r.max };
	}

	public class Result {
		int min;
		int max;
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

	public void isIn(Node node, int target, int nums[], Result result) {
		// 如果大于， 那么进行继续拆分
		if (node.end - node.start > 2) {
			divice(node);
			Node left = node.left;

			// 如果是升序
			if (nums[left.start] <= nums[left.end] && target >= nums[left.start] && target <= nums[left.end]) {
				isIn(left, target, nums, result);
			}

			Node right = node.right;
			// 如果是升序
			if (nums[right.start] <= nums[right.end] && target >= nums[right.start] && target <= nums[right.end]) {
				isIn(right, target, nums, result);
			}
			return;
		}

		if (nums[node.start] == target) {
			if (result.min == -1 || result.min > node.start) {
				result.min = node.start;
			}

			if (result.max == -1 || result.max < node.start) {
				result.max = node.start;
			}
		}

		if (node.start + 1 < nums.length) {
			if (nums[node.start + 1] == target) {
				if (result.min == -1 || result.min > node.start + 1) {
					result.min = node.start + 1;
				}

				if (result.max == -1 || result.max < node.start + 1) {
					result.max = node.start + 1;
				}
			}
		}

		if (nums[node.end] == target) {
			if (result.min == -1 || result.min > node.end) {
				result.min = node.end;
			}

			if (result.max == -1 || result.max < node.end) {
				result.max = node.end;
			}
		}
		return;
	}
}
