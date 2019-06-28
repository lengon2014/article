package article.n100;

/**
 * 31. Next Permutation Medium
 * 
 * 1572
 * 
 * 480
 * 
 * Favorite
 * 
 * Share Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2 3,2,1 → 1,2,3 1,1,5 → 1,5,1
 * 
 * @author lengon
 *
 */
public class A031 {

	public static void main(String args[]) {
		int[] nums = new int[] {2,3,1};
		nextPermutation(nums);
		System.out.println(ArrayUtils.buildInfo(nums));
	}

	public static void nextPermutation(int[] nums) {
		if (null == nums) {
			return;
		}

		for (int i = 0; i < nums.length - 1; i++) {
			// 进行swap
			int start = nums.length - 2 - i;
			
			if (nums[start+1] > nums[start]) {
				int temp = nums[nums.length - 2 - i];
				nums[nums.length - 2 - i] = nums[nums.length - 1];
				nums[nums.length - 1] = temp;
				
				//将剩下的进行升序
				int center = (int) (i+1) / 2;
				for (int j = 1; j<= center ; j++) {
					int revert = nums.length - j;
					temp = nums[j];
					nums[j] = nums[revert];
					nums[revert] = temp;
				}
				return;
			}
		}

		// 如果不存在， 那么代表当前是最大的数组， 进行逆序就可以了。
		int center = (int) nums.length / 2;
		for (int i = 0; i <= center; i++) {
			int revert = nums.length - 1 - i;
			int temp = nums[i];
			nums[i] = nums[revert];
			nums[revert] = temp;
		}
	}
}
