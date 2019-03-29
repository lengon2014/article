package article.n100;

/**
 * 26. Remove Duplicates from Sorted Array
 * 
 * @author lengon
 *
 */
public class A026 {

	public static void main(String args[]) {
		int[] nums = new int[] { 1, 1, 2 };
		System.out.println(removeDuplicates(nums));
		System.out.println(ArrayUtils.buildInfo(nums));
	}

	public static int removeDuplicates(int[] nums) {
		if (null == nums) {
			return 0;
		}
		int count = 0;
		Integer pre = null;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (pre == null || pre.intValue() != num) {
				nums[count] =num;
				count++;
				pre = num;
			}
		}
		return count;
	}
}
