package article.n30;

public class A004 {
	
	public static void main(String args[]) {
		System.out.println(findMedianSortedArrays(new int[] {}, new int[]{2,4}));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length + nums2.length];

		int nums1Index = 0;
		int nums2Index = 0;
		for (int i = 0; i < nums.length; i++) {

			boolean isNums1 = true;
			if (nums1Index >= nums1.length || (nums1Index < nums1.length && nums2Index < nums2.length
					&& nums1[nums1Index] > nums2[nums2Index])) {
				isNums1 = false;
			}

			if (isNums1) {
				nums[i] = nums1[nums1Index];
				nums1Index++;
			} else {
				nums[i] = nums2[nums2Index];
				nums2Index++;
			}
		}

		int mid = nums.length / 2;
		if (nums.length % 2 == 0) {
			return (nums[mid] + nums[mid - 1]) / 2d;
		} else {
			return nums[mid];
		}
	}
}
