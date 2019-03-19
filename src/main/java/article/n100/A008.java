package article.n100;

/**
 * 
 * @author lengon
 *
 */
public class A008 {

	public static void main(String args[]) {
		System.out.println(myAtoi("-9223372036854775809"));
	}

	public static int myAtoi(String str) {
		StringBuilder sb = new StringBuilder();
		boolean isNeg = false;
		boolean isNumber = false;
		boolean isSig = false;
		int validChar = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ' && validChar + sb.length() == 0) {
				continue;
			}

			if (str.charAt(i) == '+' && validChar + sb.length() == 0) {
				if (isSig) {
					break;
				}
				validChar++;
				isSig = true;
				continue;
			}

			if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
				if (str.charAt(i) <= '9' && str.charAt(i) >= '1') {
					isNumber = true;
				}
				if (isNumber) {
					sb.append(String.valueOf(str.charAt(i)));
				} else {
					validChar++;
				}
				continue;
			}

			if (validChar + sb.length() == 0 && str.charAt(i) == '-' && !isNeg) {
				if (isSig) {
					break;
				}
				sb.append(String.valueOf(str.charAt(i)));
				isNeg = true;
				continue;
			}
			break;
		}

		if (sb.length() > 12 && isNeg) {
			return Integer.MIN_VALUE;
		}

		if (sb.length() > 12 && !isNeg) {
			return Integer.MAX_VALUE;
		}

		if (sb.length() == 0 || sb.toString().equals("-")) {
			return 0;
		}

		long value = Long.parseLong(sb.toString());
		if (value > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}

		if (value < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		return (int) value;
	}
}
