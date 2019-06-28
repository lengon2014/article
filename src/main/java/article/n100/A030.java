package article.n100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 30. Substring with Concatenation of All Words Hard
 * 
 * 473
 * 
 * 831
 * 
 * Favorite
 * 
 * Share You are given a string, s, and a list of words, words, that are all of
 * the same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * Example 1:
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"] Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar"
 * respectively. The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 * 
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * 
 * @author lengon
 *
 */
public class A030 {

	public static void main(String args[]) {
		System.out.println(findSubstring("goodgoodbestword", new String[] {"word","good","best","good"}));
	}

	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> values = new ArrayList<>();
		if (null==s || null == words || words.length == 0) {
			return values;
		}

		int wSize = words[0].length();
		int wTotal = wSize * words.length;

		for (int m = 0; m <= s.length() - wTotal; m++) {
			Set<Integer> keys = new HashSet<>();

			boolean isAllFind = true;
			for (int i = m; i < wTotal + m; i += wSize) {
				String now = s.substring(i, i + wSize);
				boolean isFind = false;
				for (int j = 0; j < words.length; j++) {
					if (!keys.contains(j) && now.equals(words[j])) {
						keys.add(j);
						isFind = true;
						break;
					}
				}

				if (!isFind) {
					isAllFind = false;
					break;
				}
			}

			if (isAllFind) {
				values.add(m);
			}
		}
		return values;
	}
}
