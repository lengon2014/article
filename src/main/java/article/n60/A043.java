package article.n60;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * 示例 1:
 * 
 * 输入: num1 = "2", num2 = "3" 输出: "6" 示例 2:
 * 
 * 输入: num1 = "123", num2 = "456" 输出: "56088" 说明：
 * 
 * num1 和 num2 的长度小于110。 num1 和 num2 只包含数字 0-9。 num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A043 {

	public static void main(String args[]) {
		A043 a = new A043();
		System.out.println(a.multiply("1536837823", "0"));
	}

	public String multiply(String num1, String num2) {
		Map<Integer, Integer> result = new HashMap<>();

		List<Integer> num1Ints = new ArrayList<>();
		List<Integer> num2Ints = new ArrayList<>();
		for (int i = 0; i < num1.length(); i++) {
			num1Ints.add(Integer.parseInt(String.valueOf(num1.charAt(i))));
		}

		for (int i = 0; i < num2.length(); i++) {
			num2Ints.add(Integer.parseInt(String.valueOf(num2.charAt(i))));
		}

		for (int i = 0; i < num1Ints.size(); i++) {
			int nowI = num1Ints.get(num1Ints.size() - 1 - i);
			for (int j = 0; j < num2Ints.size(); j++) {
				int nowJ = num2Ints.get(num2Ints.size() - 1 - j);
				int nowResult = nowI * nowJ;
				buildNext(result, nowResult, (j + i));
			}
		}

		// 最后进行组合

		StringBuilder sb = new StringBuilder();

		int max = 0;
		for (int i : result.keySet()) {
			if (i > max) {
				max = i;
			}
		}
		int start = max;
		while (start >= 0) {
			if (result.get(start) == null) {
				sb.append("0");
			} else {
				sb.append(result.get(start));
			}
			start--;
		}
		return sb.toString();
	}

	private void buildNext(Map<Integer, Integer> result, int value, int index) {
		while (value > 0) {
			int now = value % 10;
			int next = value / 10;
			if (result.get(index) == null) {
				result.put(index, now);
			} else {
				int pre = result.get(index);
				int nowNum = (pre + now) % 10;
				next = next + (pre + now) / 10;
				result.put(index, nowNum);
			}
			value = next;
			index++;
		}
	}
}
