package article.n90;

/**
 * 67. 二进制求和 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1" 输出: "100" 示例 2:
 * 
 * 输入: a = "1010", b = "1011" 输出: "10101"
 * 
 * 
 * 提示：
 * 
 * 每个字符串仅由字符 '0' 或 '1' 组成。 1 <= a.length, b.length <= 10^4 字符串如果不是 "0" ，就都不含前导零。
 * 
 * @author lengon
 *
 */
public class A067 {
	public static void main(String args[]) {
		A067 a = new A067();
		System.out.println(a.addBinary("0", "0"));
	}

	public String addBinary(String a, String b) {
		int index = 0;
		int plus = 0;
		String result = "";
		while (true) {
			char ac = '0';
			if (a.length() - index - 1 >= 0) {
				ac = a.charAt(a.length() - index - 1);
			}
			char bc = '0';
			if (b.length() - index - 1 >= 0) {
				bc = b.charAt(b.length() - index - 1);
			}

			char next = (char) (ac + bc + plus - '0');
			if (next - '2' >= 0) {
				next = (char) (next - 2);
				plus = 1;
			}else {
				plus = 0;
			}

			//已经到了最前方的一位。
			if (a.length() - index - 1 < 0 && b.length() - index - 1 < 0) {
				if(next>'0') {
					result = next + result;
				}
				break;
			}
			result = next + result;
			index++;
		}
		return result;
	}

}
