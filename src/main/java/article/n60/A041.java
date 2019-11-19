package article.n60;

public class A041 {

	public static void main(String args[]) {
		A041 a = new A041();
		System.out.println(a.firstMissingPositive(new int[] { -1,-2}));
	}

	public int firstMissingPositive(int[] nums) {

		//先重置所有的-1的为0
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==-1) {
				nums[i]=0;
			}
		}
		
		int max = nums.length;
		for (int i = 0; i < nums.length; i++) {

			int start = nums[i];

			// 如果是小于的情况。
			if (start < 1 || start > max) {
				//nums[i] = 1;
				continue;
			}

			// 进行swap
			int index = i;
			int nextIndex = nums[index] - 1;
			while (true) {
				if (nextIndex >= 0 && nextIndex < max) {
					int temp = nextIndex;
					nextIndex = nums[nextIndex] - 1;
					nums[temp] = -1;
					if (nextIndex >= 0 && nextIndex < max) {
					} else {
						break;
					}
				} else {
					break;
				}
			}
		}

		int current = max+1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != -1) {
				return i + 1;
			}
		}
		return current;
	}
}
