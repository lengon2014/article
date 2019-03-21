package article.n100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Note that an empty string is also considered
 * valid.
 * 
 * Example 1:
 * 
 * Input: "()" Output: true Example 2:
 * 
 * Input: "()[]{}" Output: true Example 3:
 * 
 * Input: "(]" Output: false Example 4:
 * 
 * Input: "([)]" Output: false Example 5:
 * 
 * Input: "{[]}" Output: true
 * 
 * @author lengon
 *
 */
public class A020 {
	public static void main(String args[]) {
		System.out.println(isValid("([{}])"));
	}

	public static boolean isValid(String s) {

		Map<Character, Character> vs = new HashMap<>();
		vs.put('(', ')');
		vs.put('[', ']');
		vs.put('{', '}');
		if (s == null) {
			return true;
		}
		List<Character> chars = new ArrayList<>();
		Character last = null;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (last == null) {
				if (!vs.containsKey(c)) {
					return false;
				}
				chars.add(c);
				last = c;
			} else {
				if (c == vs.get(last)) {
					chars.remove(chars.size() - 1);
					if (!chars.isEmpty()) {
						last = chars.get(chars.size() - 1);
					} else {
						last = null;
					}
				} else {
					if (!vs.containsKey(c)) {
						return false;
					}
					chars.add(c);
					last = c;
				}
			}
		}

		return chars.isEmpty();
	}
}
