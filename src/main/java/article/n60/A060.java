package article.n60;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 
 * "123" "132" "213" "231" "312" "321" 给定 n 和 k，返回第 k 个排列。
 * 
 * 说明：
 * 
 * 给定 n 的范围是 [1, 9]。 给定 k 的范围是[1,  n!]。 示例 1:
 * 
 * 输入: n = 3, k = 3 输出: "213" 示例 2:
 * 
 * 输入: n = 4, k = 9 输出: "2314"
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A060 {
	public static void main(String args[]) {
		A060 a = new A060();
		System.out.println(a.getPermutation(4, 9));
	}

	public String getPermutation(int n, int k) {

		Integer[] values = new Integer[n];
		for (int i = 0; i < n; i++) {
			values[i] = (i + 1);
		}

		String result = "";
		// 对应的进行取模， 当前的index为
		int index = n;
		while (true) {
			if (index == 0) {
				break;
			}
			// 小一位的最大的阶乘
			long maxIndex = factorial(index - 1);

			// 表示是第一位
			int offset = 0;
			if (k % maxIndex == 0) {
				offset = (int) (k / maxIndex) - 1;
			} else {
				offset = (int) (k / maxIndex);
			}

			// 从values里面取从小到大的第几位
			result += getValue(values, offset);
			k -= offset * maxIndex;
			index--;
		}
		return result;

	}

	public int getValue(Integer[] values, int index) {
		int offset = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				if (offset == index) {
					int tmp = values[i];
					values[i] = null;
					return tmp;
				}
				offset++;
			}
		}
		return -1;
	}

	public long factorial(long number) {
		if (number <= 1)
			return 1;
		else
			return number * factorial(number - 1);
	}
}
