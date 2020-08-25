package article.n90;

public class A070 {

	public static void main(String args[]) {
		A070 a = new A070();
		System.out.println(a.climbStairs(3));
	}

	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int[] values = new int[n];
		// 第一步
		values[0] = 1;
		values[1] = 2;

		// 当前的数字
		for (int i = 2; i < n; i++) {
			values[i] = values[i - 1] + values[i - 2];
		}
		return values[n - 1];
	}
}
