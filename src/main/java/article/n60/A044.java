package article.n60;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A044 {

	public static void main(String[] args) {
		A044 a = new A044();
		System.out.println(a.isMatch(
				"baaabbabbbaabbbbbbabbbaaabbaabbbbbaaaabbbbbabaaaaabbabbaabaaababaabaaabaaaabbabbbaabbbbbaababbbabaaabaabaaabbbaababaaabaaabaaaabbabaabbbabababbbbabbaaababbabbaabbaabbbbabaaabbababbabababbaabaabbaaabbba",
				"*b*ab*bb***abba*a**ab***b*aaa*a*b****a*b*bb**b**ab*ba**bb*bb*baab****bab*bbb**a*a*aab*b****b**ba**abba"));
	}

	
	private Boolean isMatched(String s, String p, Map<String, Boolean> keys) {
		String key = s + ";" + p;
		if (key.contains(key)) {
			return keys.get(key);
		} else {
			return null;
		}

	}

	private void addMatched(String s, String p, boolean match, Map<String, Boolean> keys) {
		String key = s + ";" + p;
		keys.put(key, match);
	}

	public boolean isMatch(String s, String p) {
		Map<String, Boolean> maps = new HashMap<>();
		return isMatch(s, p, maps);
	}

	public boolean isMatch(String s, String p, Map<String, Boolean> keys) {
		Boolean isBefore = isMatched(s, p, keys);
		if (isBefore != null) {
			return isBefore;
		}
		//System.out.println(s+"---->"+p);
		if (!p.contains("*") && p.length() != s.length()) {
			addMatched(s, p, false, keys);
			return false;
		}
		StringBuilder combine = new StringBuilder();
		// 首先要判断存不存在
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*' || p.charAt(i) == '?') {
				String content = sb.toString();
				if (!s.contains(content)) {
					addMatched(s, p, false, keys);
					return false;
				}
				sb = new StringBuilder();
			} else {
				sb.append(p.charAt(i));
			}
			if (i + 1 < p.length() && p.charAt(i) == p.charAt(i + 1) && p.charAt(i) == '*') {
			} else {
				combine.append(p.charAt(i));
			}
		}

		String content = sb.toString();
		if (!s.contains(content)) {
			addMatched(s, p, false, keys);
			return false;
		}
		p = combine.toString();

		String newPs = p.replace("*", "");
		if (newPs.length() > s.length()) {
			addMatched(s, p, false, keys);
			return false;
		}

		if (s.equals("") && p.equals("")) {
			addMatched(s, p, true, keys);
			return true;
		}

		int pIndex = 0;
		List<String> dotMatch = new ArrayList<>();
		List<String> dotLeft = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			if (pIndex > p.length() - 1) {
				addMatched(s, p, false, keys);
				return false;
			}

			if (p.charAt(pIndex) != '*') {
				if (p.charAt(pIndex) == s.charAt(i) || p.charAt(pIndex) == '?') {
					pIndex++;
				} else {
					addMatched(s, p, false, keys);
					return false;
				}
			} else {
				// 需要找到的是下一个以xx开头的
				int nextDotndex = pIndex + 1;
				for (int m = pIndex + 1; m < p.length(); m++) {
					if (p.charAt(m) == '*' || p.charAt(m) == '?') {
						nextDotndex = m;
						break;
					}
				}
				String nextChars = p.substring(pIndex + 1, nextDotndex);
				for (int j = i; j + nextChars.length() <= s.length(); j++) {
					// 判断下一个和其相符合的
					String nextc = s.substring(j, j + nextChars.length());
					if (nextc.equals(nextChars)) {
						dotMatch.add(s.substring(i, j));
						dotLeft.add(s.substring(j));
					}
				}

				boolean isLeftMatch = false;
				String newP = p.substring(pIndex + 1);
				List<String> matches = new ArrayList<>();
				for (int m = 0; m < dotMatch.size(); m++) {
					if (isMatch(dotLeft.get(m), newP, keys)) {
						isLeftMatch = true;
						matches.add(dotLeft.get(m));
						break;
					}
				}

				if (!isLeftMatch) {
					addMatched(s, p, false, keys);
					return false;
				} else {
					addMatched(s, p, true, keys);
					return true;
				}
			}
		}

		// 判定最后遗留的p是否是*，如果不是，那么返回false
		String leftPStr = p.substring(pIndex);
		for (int i = 0; i < leftPStr.length(); i++) {
			if (leftPStr.charAt(i) != '*') {
				addMatched(s, p, false, keys);
				return false;
			}
		}
		addMatched(s, p, true, keys);
		return true;
	}
}
