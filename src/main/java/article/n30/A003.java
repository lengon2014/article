package article.n30;

public class A003 {

	public static void main(String args[]) {
		String s = "1";
		System.out.println(String.valueOf(build(s)));
	}

	public static int build(String s) {
		int maxLength = 0;
		String maxString = "";
		for (int i = 0; i < s.length(); i++) {
			StringBuilder content = new StringBuilder();
			content.append(s.substring(i, i + 1));
			for (int j = i+1; j < s.length(); j++) {
				String nowChar = s.substring(j, j + 1);
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
		return maxString.length();
	}
}
