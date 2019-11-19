package article.n30;

/**
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * Input: haystack = "hello", needle = "ll" Output: 2 Example 2:
 * 
 * Input: haystack = "aaaaa", needle = "bba" Output: -1
 * 
 * @author lengon
 *
 */
public class A028 {

	public static void main(String args[]) {
		System.out.println(strStr("aabaa", "baa"));

	}

	public static int strStr(String haystack, String needle) {

		if (null == haystack || needle == null) {
			return -1;
		}

		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			boolean isFind = true;
			for (int j = 0; j < needle.length(); j++) {

				if (haystack.charAt(i + j) != needle.charAt(j)) {
					isFind = false;
					break;
				}
			}

			if (isFind) {
				return i;
			}
		}

		return -1;
	}
}
