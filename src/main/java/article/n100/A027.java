package article.n100;

/**
 * 27. Remove Element
 * 
 * @author lengon
 *
 */
public class A027 {

	public static void main(String args[]) {
		int[] nums = new int[] { 0,1,2,2,3,0,4,2};
		System.out.println(removeElement(nums,2));
		System.out.println(ArrayUtils.buildInfo(nums));
	}

	public static int removeElement(int[] nums, int val) {
		int index = 0;
		for (int num : nums) {
			if (num != val) {
				nums[index] = num;
				index++;
			}
		}

		return index;
	}
}
