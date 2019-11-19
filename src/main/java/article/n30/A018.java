package article.n30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 18. 4Sum Medium
 * 
 * 929
 * 
 * 187
 * 
 * Favorite
 * 
 * Share Given an array nums of n integers and an integer target, are there
 * elements a, b, c, and d in nums such that a + b + c + d = target? Find all
 * unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 * 
 * @author lengon
 *
 */
public class A018 {

	public static void main(String args[]) {
		long start = System.currentTimeMillis();
		System.out.println(fourSum(new int[] { -5, 5, 4, -3, 0, 0, 4, -2 }, 4));
		System.out.println(System.currentTimeMillis() - start);
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		if (nums == null || nums.length < 4) {
			return new ArrayList<>();
		}
		Arrays.sort(nums);
		Set<String> key = new HashSet<>();
		List<List<Integer>> result = new ArrayList<>();
		for (int start = 0; start < nums.length; start++) {
			for (int end = nums.length - 1; end > start; end--) {
				int medium = start + 1;
				int max = end - 1;
				int sum = nums[start] + nums[end];
				while (medium < max) {
					int gap = nums[medium] + nums[max] + sum;
					if (gap == target) {
						if (key.add(nums[start] + "/" + nums[medium] + "/" + nums[max] + "/" + nums[end])) {
							result.add(Arrays.asList(nums[start], nums[medium], nums[max], nums[end]));
						}
					}
					if (gap - target > 0) {
						max--;
					} else {
						medium++;
					}
				}
			}
		}
		return result;
	}

	public static String buildStr(List<List<Integer>> input) {
		StringBuilder sb = new StringBuilder();
		for (List<Integer> value : input) {
			for (Integer v : value) {
				sb.append(v).append(",");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
