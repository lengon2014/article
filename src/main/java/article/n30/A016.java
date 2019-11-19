package article.n30;

import java.util.Arrays;
import java.util.List;

/**
 * 16. 3Sum Closest Medium
 * 
 * 951
 * 
 * 76
 * 
 * Favorite
 * 
 * Share Given an array nums of n integers and an integer target, find three
 * integers in nums such that the sum is closest to target. Return the sum of
 * the three integers. You may assume that each input would have exactly one
 * solution.
 * 
 * Example:
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author lengon
 *
 */
public class A016 {
	public static void main(String args[]) {
		long start = System.currentTimeMillis();
		System.out.println(threeSum(new int[] { 0,1,2 }, 0));
		System.out.println(System.currentTimeMillis() - start);
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

	public static int threeSum(int[] nums, int target) {
		if (nums.length < 3) {
			return 0;
		}
		Arrays.sort(nums);
		int closest = Math.abs(nums[0] + nums[1] + nums[2] - target);
		int num = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			int medium = i + 1;
			int max = nums.length - 1;
			while (medium < max) {
				if (nums[medium] + nums[max] + nums[i] == target) {
					return target;
				}

				int gap = nums[medium] + nums[max] + nums[i] - target;

				if (Math.abs(gap) < closest) {
					closest = Math.abs(gap);
					num = nums[medium] + nums[max] + nums[i];
				}

				if (gap > 0) {
					max--;
				} else {
					medium++;
				}

			}
		}

		return num;
	}
}
