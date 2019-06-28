package article.n100;

public class A029 {

	public static void main(String args[]) {
		// System.out.println(0 - (-2147483648));
		System.out.println(divide(-2147483648, 1));
	}

	public static int divide(int dividend, int divisor) {

		if (dividend == Integer.MIN_VALUE && divisor == 1) {
			return Integer.MIN_VALUE;
		}
		long dd = 0L + dividend;
		long dr = 0L + divisor;
		int msb = 0;

		boolean flag = (dd > 0 && dr > 0) || (dd < 0 && dr < 0);

		if (dd < 0) {
			dd = -dd;
		}

		if (dr < 0) {
			dr = -dr;
		}
		long size = 0;
		while (size < dd) {
			size = dr << msb;
			msb++;
		}
		int q = 0;
		for (int i = msb; i >= 0; i--) {
			long t = (dr << i);
			if (t > dd)
				continue;
			q |= (1 << i);
			dd -= t;
		}

		if (q < 0) {
			q = -q - 1;
		}
		if (!flag)
			return -q;
		return q;
	}
}
