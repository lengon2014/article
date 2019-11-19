package article.n60;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
 * 
 * 输入: "(()" 输出: 2 解释: 最长有效括号子串为 "()" 示例 2:
 * 
 * 输入: ")()())" 输出: 4 解释: 最长有效括号子串为 "()()"
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A032 {

	public static void main(String args[]) {
		System.out.print(longestValidParentheses("(()"));
	}

	public static int longestValidParentheses(String s) {
		while (true) {
			StringBuilder newC = new StringBuilder();
			boolean isGet = false;
			for (int i = 0; i < s.length(); i++) {
				boolean isReplace = false;
				if (s.charAt(i) == '(') {
					for (int j = i + 1; j < s.length(); j++) {
						if (s.charAt(j) == '-') {
							continue;
						}

						if (s.charAt(j) == '(') {
							break;
						}

						if (s.charAt(j) == ')') {
							for (int m = i; m <= j; m++) {
								newC.append("-");
							}
							i = j;
							isReplace = true;
							isGet = true;
							break;
						}
					}
				}
				if (!isReplace) {
					newC.append(s.charAt(i));
				}
			}

			s = newC.toString();
			int max = 0;
			int count = 0;
			if (!isGet) {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == '-') {
						count++;
					} else {
						if (max < count) {
							max = count;
						}
						count = 0;
					}
				}
				if (max < count) {
					max = count;
				}
				return max;
			}

		}
	}
}
