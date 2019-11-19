package article.n30;

import java.util.ArrayList;
import java.util.List;

/**
 * 10. Regular Expression Matching Hard
 * 
 * 2311
 * 
 * 458
 * 
 * Favorite
 * 
 * Share Given an input string (s) and a pattern (p), implement regular
 * expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element. The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * s could be empty and contains only lowercase letters a-z. p could be empty
 * and contains only lowercase letters a-z, and characters like . or *. Example
 * 1:
 * 
 * Input: s = "aa" p = "a" Output: false Explanation: "a" does not match the
 * entire string "aa". Example 2:
 * 
 * Input: s = "aa" p = "a*" Output: true Explanation: '*' means zero or more of
 * the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes
 * "aa". Example 3:
 * 
 * Input: s = "ab" p = ".*" Output: true Explanation: ".*" means "zero or more
 * (*) of any character (.)". Example 4:
 * 
 * Input: s = "aab" p = "c*a*b" Output: true Explanation: c can be repeated 0
 * times, a can be repeated 1 time. Therefore it matches "aab". Example 5:
 * 
 * Input: s = "mississippi" p = "mis*is*p*." Output: false
 * 
 * @author lengon
 *
 */
public class A010 {

	public static boolean isMatch(String s, String p) {
		if (s.equals("") && p.equals("")) {
			return true;
		}

		if (s.equals("") && p.length() > 0) {
			for (int i = 0; i < p.length(); i++) {
				if (i + 1 < p.length()) {
					if (p.charAt(i) != '*' && p.charAt(i + 1) != '*') {
						return false;
					} else {
						continue;
					}
				} else {
					if (p.charAt(i) != '*') {
						return false;
					} else {
						continue;
					}
				}
			}
		}

		int pIndex = 0;
		List<String> dotMatch = new ArrayList<>();
		List<String> dotLeft = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			if (pIndex > p.length() - 1) {
				return false;
			}

			if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
				dotMatch.add(s.substring(i, i));
				dotLeft.add(s.substring(i));

				for (int j = i; j < s.length(); j++) {
					if (s.charAt(j) == p.charAt(pIndex) || p.charAt(pIndex) == '.') {
						dotMatch.add(s.substring(i, j + 1));
						dotLeft.add(s.substring(j + 1));
					} else {
						break;
					}
				}

				boolean isLeftMatch = false;
				String newP = p.substring(pIndex + 2);
				List<String> matches = new ArrayList<>();
				for (int m = 0; m < dotMatch.size(); m++) {
					if (isMatch(dotLeft.get(m), newP)) {
						isLeftMatch = true;
						matches.add(dotLeft.get(m));
					}
				}

				if (!isLeftMatch) {
					return false;
				} else {
					return true;
				}

			} else {
				if (p.charAt(pIndex) == s.charAt(i) || p.charAt(pIndex) == '.') {
					pIndex++;
				} else {
					return false;
				}
			}
		}

		p = p.substring(pIndex);

		if (p.length() > 0) {
			for (int i = 0; i < p.length(); i++) {
				if (i + 1 < p.length()) {
					if (p.charAt(i) != '*' && p.charAt(i + 1) != '*') {
						return false;
					} else {
						continue;
					}
				} else {
					if (p.charAt(i) != '*') {
						return false;
					} else {
						continue;
					}
				}

			}
		}

		return true;
	}

	public static void main(String args[]) {
		System.out.println(isMatch("a", "ab*"));
	}
}
