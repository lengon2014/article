package article.n30;

/**
 * Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000
 * 
 * @author lengon
 *
 */
public class A012 {

	public static void main(String args[]) {
		System.out.println(intToRoman(58));
	}

	public static String intToRoman(int num) {

		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			String[] level = getLevels(num);
			int now = num;
			int rate = 1;
			if (num >= 10) {
				while (rate * 10 <= num) {
					rate = rate * 10;
				}
				now = num / rate;
			}
			build1(now, level, sb);
			num = num - now * rate;
		}

		return sb.toString();
	}

	public static void build1(int number, String levels[], StringBuilder sb) {
		switch (number) {
		case 1:
			sb.append(levels[0]);
			return;
		case 2:
			sb.append(levels[0]).append(levels[0]);
			return;
		case 3:
			sb.append(levels[0]).append(levels[0]).append(levels[0]);
			return;
		case 4:
			sb.append(levels[0]).append(levels[1]);
			return;
		case 5:
			sb.append(levels[1]);
			return;
		case 6:
			sb.append(levels[1]).append(levels[0]);
			return;
		case 7:
			sb.append(levels[1]).append(levels[0]).append(levels[0]);
			return;
		case 8:
			sb.append(levels[1]).append(levels[0]).append(levels[0]).append(levels[0]);
			return;
		case 9:
			sb.append(levels[0]).append(levels[2]);
			return;
		}
	}

	public static String[] getLevels(int number) {
		if (number < 10) {
			return new String[] { "I", "V", "X" };
		}

		if (number < 100) {
			return new String[] { "X", "L", "C" };
		}

		if (number < 1000) {
			return new String[] { "C", "D", "M" };
		}

		return new String[] { "M" };
	}
}
