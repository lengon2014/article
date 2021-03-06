package article.n30;

/**
 * Palindrome Number
 * 
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward.
 * 
 * Example 1:
 * 
 * Input: 121 Output: true Example 2:
 * 
 * Input: -121 Output: false Explanation: From left to right, it reads -121.
 * From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * 
 * Input: 10 Output: false Explanation: Reads 01 from right to left. Therefore
 * it is not a palindrome.
 * 
 * @author lengon
 *
 */
public class A009 {

	public static void main(String args[]) {
		System.out.println(isPalindrome(1221));
	}

	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		String input = String.valueOf(x);
		for (int i = 0; i < input.length(); i++) {
			int revert = input.length() - 1 - i;
			if (i >= revert) {
				break;
			}

			if (input.charAt(i) != input.charAt(revert)) {
				return false;
			}
		}

		return true;
	}

}
