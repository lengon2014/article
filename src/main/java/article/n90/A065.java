package article.n90;

public class A065 {

	public static void main(String args[]) {
		A065 a = new A065();
		System.out.println(a.isNumber("-.3e6"));
	}

	public boolean isNumber(String s) {
		s = s.trim();
		
		if(s.equals("")) {
			return false;
		}
		String chars = new String();
		boolean isE = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != '+' && c != '-' && !(c >= '0' && c <= '9') && c != 'e' && c != '.') {
				return false;
			}

			// 减号， 那么获得后面的所有的数字
			if (c == '-' || c == '+') {
				String nextStr = "";
				for (; i < s.length() - 1; i++) {
					char next = s.charAt(i + 1);
					if (next >= '0' && next <= '9' || next == '.') {
						nextStr += next;
					} else {
						break;
					}
				}

				if(!chars.equals("")) {
					return false;
				}
				if ((nextStr.equals("") && i + 1 < s.length() && s.charAt(i + 1) != 'e')||(nextStr.equals("") && i+1 >= s.length())) {
					return false;
				}

				if (!numberCheck(nextStr)) {
					return false;
				}
				
				chars  = nextStr;
			} else

			if (c == 'e') {
				if (isE) {
					return false;
				}
				isE = true;
				// 如果是e， 那么将前面的进行合并
				String nextStr = "";
				
				//如果后面的是+- 。 那么进行跳过
				if(i+1 < s.length() && (s.charAt(i+1)=='-'|| s.charAt(i+1)=='+')) {
					i=i+1;
				}
				for (; i < s.length()-1; i++) {
					char next = s.charAt(i+1);
					if (next >= '0' && next <= '9' || next == '.') {
						nextStr += next;
					} else {
						break;
					}
				}

				if(chars.equals("")) {
					return false;
				}
				if (nextStr.equals("")) {
					return false;
				}

				if (nextStr.contains(".")) {
					return false;
				}

				if (!numberCheck(nextStr)) {
					return false;
				}

				if (!numberCheck(chars)) {
					return false;
				}
				chars = "";
			} else {
				chars += c;
			}

		}
		return numberCheck(chars);

	}

	// 只要判断小数点
	private boolean numberCheck(String input) {
		if (input.equals(".")) {
			return false;
		}
		// 只有一个.的情况
		if (input.indexOf(".") != input.lastIndexOf(".")) {
			return false;
		}
		return true;
	}

}
