package article.n30;

import article.ArrayUtils;

public class A001 {

	public static void main(String args[]) {
		int[] input = new int[] { 2, 7,11,15 };
		int target = 9;
		int[] result = buildIndex(input, target);
		System.out.println(ArrayUtils.buildInfo(result));
	}

	public static int[] buildIndex(int[] nums, int target) {
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]+nums[j]==target){
					return new int[] {i,j};
				}
			}
		}
		
		return null;
	}
}
