package article;

/**
 * 14. Longest Common Prefix Easy
 * 
 * 1194
 * 
 * 1204
 * 
 * Favorite
 * 
 * Share Write a function to find the longest common prefix string amongst an
 * array of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * Input: ["flower","flow","flight"] Output: "fl" Example 2:
 * 
 * Input: ["dog","racecar","car"] Output: "" Explanation: There is no common
 * prefix among the input strings.
 * 
 * @author lengon
 *
 */
public class A014 {

	public static void main(String args[]) {
		System.out.println(longestCommonPrefix(new String[] {}));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		int index = 0;
		while (true) {
			if (index >= strs[0].length()) {
				break;
			}
			char first = strs[0].charAt(index);
			boolean isMatch = true;
			for (int i = 1; i < strs.length; i++) {
				if (index >= strs[i].length()) {
					isMatch = false;
					break;
				}

				if (strs[i].charAt(index) != first) {
					isMatch = false;
					break;
				}
			}

			if (!isMatch) {
				break;
			}
			index++;
		}

		if (index == 0) {
			return "";
		}
		return strs[0].substring(0, index);
	}
}
