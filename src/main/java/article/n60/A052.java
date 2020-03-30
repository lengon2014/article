package article.n60;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A052 {

	public static void main(String args[]) {
		A052 a = new A052();
		int result = a.totalNQueens(4);
		System.out.println(result);
	}

	public int totalNQueens(int n) {
		int[] queens = new int[n];
		List<Integer> result = new ArrayList<>();
		result(queens, 1, n, result);
		return result.size();
	}

	public void result(int[] input, int index, int n, List<Integer> result) {

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
				result.add(1);
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
}
