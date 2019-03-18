package article;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer. Example 2:
 * 
 * Input: "cbbd" Output: "bb"
 * 
 * @author lengon
 *
 */
public class A005 {

	public static void main(String args[]) {
		System.out.println(longestPalindrome("cbb"));
	}

	public static String longestPalindrome(String s) {
		String longest = "";
		for (int i = 0; i < s.length(); i++) {

			char nowChar = s.charAt(i);
			StringBuilder now = new StringBuilder(String.valueOf(s.charAt(i)));
			int left = i;
			int right = i;
			while (i < s.length() - 1) {
				if (s.charAt(i + 1) == nowChar) {
					right = i + 1;
					now.append(nowChar);
					i++;
				} else {
					break;
				}
			}
			int minDistance = Math.min(left, s.length() - right - 1);
			for (int j = 1; j <= minDistance; j++) {
				if (s.charAt(left - j) != s.charAt(right + j)) {
					break;
				}

				now.insert(0, String.valueOf(s.charAt(left - j)));
				now.append(String.valueOf(s.charAt(left - j)));
			}

			if (now.length() > longest.length()) {
				longest = now.toString();
			}
		}
		return longest;
	}
}
