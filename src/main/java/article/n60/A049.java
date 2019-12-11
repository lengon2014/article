package article.n60;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A049 {

	public static void main(String args[]) {
		A049 a = new A049();
		String[] strs = new String[10000];
		for (int i = 0; i < strs.length; i++) {
			strs[i] = buildRandom();
		}

		long now = System.currentTimeMillis();
		List<List<String>> result = a.groupAnagrams(strs);
		/*
		 * for (List<String> r : result) { System.out.println(r); }
		 */
		System.out.println(System.currentTimeMillis() - now);
	}

	public static String buildRandom() {
		char a = 'a';
		int size = 2 + (int) (Math.random() * 10);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			char c = (char) (a + Math.random() * 26);
			sb.append(c);
		}
		return sb.toString();
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null) {
			return null;
		}
		Map<StrKey, List<String>> values = new HashMap<>();
		for (String str : strs) {
			StrKey key = getKey(values, str);
			if (key == null) {
				List<String> list = new ArrayList<>();
				list.add(str);
				values.put(new StrKey(str, keyCount(str)), list);
			} else {
				values.get(key).add(str);
			}
		}

		List<List<String>> result = new ArrayList<>();
		for (StrKey key : values.keySet()) {
			result.add(values.get(key));
		}

		return result;
	}

	private StrKey getKey(Map<StrKey, List<String>> values, String key) {
		for (StrKey k : values.keySet()) {
			if (isSame(k, key)) {
				return k;
			}
		}
		return null;
	}

	private boolean isSame(StrKey key1, String key2) {
		if (key1.key.length() != key2.length()) {
			return false;
		}
		int start = key1.charCount;
		int end = 0;

		for (int j = 0; j < key2.length(); j++) {
			end += key2.charAt(j);
		}

		if (start == end) {
			// 因为都是小写的字母， 那么直接用char来表即可
			List<Character> keyChars = new ArrayList<>();
			for (int i = 0; i < key1.key.length(); i++) {
				keyChars.add(key1.key.charAt(i));
			}
			for (int j = 0; j < key2.length(); j++) {
				Character c = key2.charAt(j);
				keyChars.remove(c);
			}
			return keyChars.isEmpty();
		} else {
			return false;
		}
	}

	private int keyCount(String key) {
		int count = 0;
		for (int j = 0; j < key.length(); j++) {
			count += key.charAt(j);
		}
		return count;
	}

	class StrKey {
		int charCount;
		String key;

		public StrKey(String key, int count) {
			this.charCount = count;
			this.key = key;
		}
	}
}
