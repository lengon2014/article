package article.n60;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * @author lengon
 *
 */
public class A051 {

	public static void main(String args[]) {
		A051 a = new A051();
		List<List<String>> result = a.solveNQueens(9);
		for (List<String> r : result) {
			System.out.println("--------------?");
			for (String key : r) {
				System.out.println(key);
			}
		}
	}

	public List<List<String>> solveNQueens(int n) {
		// 初始化第一个， 类似一个算盘串珠， 每个下标代表第n列， 里面的数字代表第x行， 要保证x只有一个，斜的只有一个,
		int[] queens = new int[n];
		List<List<String>> result = new ArrayList<>();
		result(queens, 1, n, result);
		return result;
	}

	public void result(int[] input, int index, int n, List<List<String>> result) {

		Set<Integer> left = buildKeys(n);
		for (int i = 1; i < index; i++) {
			left.remove(input[i - 1]);
			left.remove(buildDownKeys(i, input[i - 1], index));
			left.remove(buildUpKeys(i, input[i - 1], index));
		}

		if (left.isEmpty()) {
			return;
		}

		for (Integer l : left) {
			int[] clone = clone(input, n);
			clone[index - 1] = l;
			if (index == n) {
				buildResult(result, clone, n);
				return;
			} else {
				result(clone, index + 1, n, result);
			}
		}
	}

	private int[] clone(int[] input, int n) {
		int[] clone = new int[n];
		for (int i = 0; i < n; i++) {
			clone[i] = input[i];
		}
		return clone;
	}

	private int buildDownKeys(int x, int y, int index) {
		return index - x + y;
	}

	private int buildUpKeys(int x, int y, int index) {
		return x + y - index;
	}

	private Set<Integer> buildKeys(int n) {
		Set<Integer> keys = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			keys.add(i);
		}
		return keys;
	}

	private void buildResult(List<List<String>> result, int[] input, int n) {
		List<String> r = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (input[i] - 1 == j) {
					sb.append("Q");
				} else {
					sb.append(".");
				}
			}
			r.add(sb.toString());
		}
		result.add(r);
	}
}
