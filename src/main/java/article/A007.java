package article;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * Input: 123 Output: 321 Example 2:
 * 
 * Input: -123 Output: -321 Example 3:
 * 
 * Input: 120 Output: 21
 * 
 * @author lengon
 *
 */
public class A007 {
	public static void main(String args[]) {
		System.out.println(reverse(
				-2147483648));
	}

	public static int reverse(int x) {
		boolean isNeg = x < 0;
		long x1 = x;
		if (isNeg) {
			x1 = 0 - x1;
		}
		String value = String.valueOf(x1);
		StringBuilder sb = new StringBuilder();
		for (int i = value.length() - 1; i >= 0; i--) {
			sb.append(String.valueOf(value.charAt(i)));
		}

		long revert = Long.parseLong(sb.toString());
		if(revert>Integer.MAX_VALUE) {
			return 0;
		}
		
		if (isNeg) {
			revert = 0 - revert;
		}
		return (int) revert;
	}
}
