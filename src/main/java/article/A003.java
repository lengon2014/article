package article;

public class A003 {

	public static void main(String args[]) {
		String input = "1";
		System.out.println(build(input).length());
	}

	public static String build(String input) {
		int maxLength = 0;
		String maxString = "";
		for (int i = 0; i < input.length(); i++) {
			StringBuilder content = new StringBuilder();
			content.append(input.substring(i, i + 1));
			for (int j = i+1; j < input.length(); j++) {
				String nowChar = input.substring(j, j + 1);
				if (content.indexOf(nowChar) > -1) {
					break;
				}
				content.append(nowChar);
			}
			if (content.length() > maxLength) {
				maxLength = content.length();
				maxString = content.toString();
			}
		}
		return maxString;
	}
}
