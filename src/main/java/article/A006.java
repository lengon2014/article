package article;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * 
 * 6. ZigZag Conversion Medium
 * 
 * 932
 * 
 * 2870
 * 
 * Favorite
 * 
 * Share The string "PAYPALISHIRING" is written in a zigzag pattern on a given
 * number of rows like this: (you may want to display this pattern in a fixed
 * font for better legibility)
 * 
 * P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string s, int numRows); Example 1:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3 Output: "PAHNAPLSIIGYIR" Example 2:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4 Output: "PINALSIGYAHRPI"
 * Explanation:
 * 
 * P I N A L S I G Y A H R P I
 * 
 * @author lengon
 *
 */
public class A006 {

	public static void main(String args[]) {
		System.out.println(convert("PAYPALISHIRING", 2));
	}

	public static String convert(String s, int numRows) {

		StringBuilder sb = new StringBuilder(s.length());
		if (numRows == 1) {
			return s;
		}
		List<StringBuilder> sbs = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			StringBuilder temp = new StringBuilder();
			sbs.add(temp);
		}

		int dir = 1;
		int index = 1;
		for (int i = 0; i < s.length(); i++) {
			if (index == 1) {
				dir = 1;
				index = 1;
			}
			sbs.get(index - 1).append(String.valueOf(s.charAt(i)));
			if (dir == 1) {
				if (index == numRows) {
					dir = -1;
					index = numRows - 1;
					continue;
				} else {
					index++;
				}
			}

			if (dir == -1) {
				if (index == 2) {
					dir = 1;
					index = 1;
					continue;
				} else {
					index--;
				}
			}
		}

		for (StringBuilder temp : sbs) {
			sb.append(temp.toString());
		}
		return sb.toString();
	}
}
