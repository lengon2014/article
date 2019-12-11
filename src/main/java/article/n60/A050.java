package article.n60;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * @author lengon
 *
 */
public class A050 {

	public static void main(String args[]) {
		A050 a = new A050();
		System.out.println(a.myPow(0.00001,2147483647));
	}

	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		boolean isNeg = n < 0;
		if(isNeg) {
			n = 0-n;
		}
		int start = 1;
		double value = x;
		n = n - 1;
		while (n != 0) {
			double temp = x;
			while (start * 2 < n && start *2 >0) {
				temp = temp * temp; 
				start = start * 2;
			}
			n -= start;
			start = 1;
			if (1 == n) {
				value = value * temp * x;
				n -= 1;
			} else {
				value = value * temp;
			}
		}
		
		if(isNeg) {
			return 1/value;
		}
		return value;
	}
}
