package article;

public class A013 {

	public static void main(String args[]) {
		System.out.println(romanToInt("IV"));
	}

	public static int romanToInt(String s) {
		int number = 0;
		for (int i = 0; i < s.length(); i++) {
			int value = getNumber(s.charAt(i));
			if (isNeg(s, i)) {
				number -= value;
			} else {
				number += value;
			}
		}
		return number;
	}

	public static boolean isNeg(String s, int index) {
		String value = "IVXLCDM";
		int sIndex = value.indexOf(s.substring(index, index + 1));
		for (int i = index; i < s.length(); i++) {
			int tIndex = value.indexOf(s.substring(i, i + 1));
			if (sIndex < tIndex) {
				return true;
			}
		}
		return false;
	}

	public static int getNumber(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;

		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}

		return 0;
	}

}
