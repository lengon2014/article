package article.n30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A017 {

	public static void main(String args[]) {
		System.out.println(letterCombinations("222"));
	}

	public static List<String> letterCombinations(String digits) {
		Map<String, List<Character>> letters = new HashMap<>();
		int index = 1;
		int key = 2;
		List<Character> cur = new ArrayList<>();
		letters.put("2", cur);
		for (char i = 'a'; i <= 'z'; i++) {
			if (((key == 7 || key == 9) && index % 5 == 0) || (key != 7 && key != 9 && index % 4 == 0)) {
				index = 1;
				key++;
				cur = new ArrayList<>();
				letters.put(String.valueOf(key), cur);
			}
			cur.add(i);
			index++;
		}

		List<String> sbs = new ArrayList<>();
		for (int i = 0; i < digits.length(); i++) {
			String num = digits.substring(i, i + 1);
			if (letters.containsKey(num) && !letters.get(num).isEmpty()) {
				List<Character> cs = letters.get(num);
				List<String> news = new ArrayList<>();
				for (Character c : cs) {
					if (sbs.isEmpty()) {
						news.add(String.valueOf(c));
					} else {
						for (String sb : sbs) {
							news.add(new String(sb + c));
						}
					}
				}
				sbs = news;
			}
		}
		return sbs;
	}
}
