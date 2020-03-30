package article.n60;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * @author lengon
 *
 */
public class A053 {
	public static void main(String args[]) {
		A053 a = new A053();
		System.out.println(a.maxSubArray(new int[] { 4,-1,2,1 }));
	}

	public int maxSubArray(int[] nums) {
		int max = nums[0];
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			for (int j = i; j < nums.length; j++) {
				count += nums[j];
				if (count > max) {
					max = count;
				}
			}
		}
		return max;
	}
}
